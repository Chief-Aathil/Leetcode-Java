import java.util.Collections;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Q853 {
    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            /**
             Sort positions in desc order.
             Iterate and group cars whose time>next car's time.
             Push the group into a stack.
             Length of stack = no of carFleet
             */

            //Sort by position in desc
            Map<Integer,Double> carMap = new TreeMap<>(Collections.reverseOrder());
            for(int i=0;i<position.length; i++){
                carMap.put(position[i],(double)(target-position[i])/speed[i]);
            }

            //Group cars to form fleet
            Stack<Double> fleet = new Stack<>();
            for(var carTime: carMap.values()){
                Double currentFleetTime = fleet.isEmpty()? 0: fleet.peek();
                if(carTime>currentFleetTime && carTime!=0){
                    fleet.push(carTime);
                }
            }
            return fleet.size();

        }
    }
}
