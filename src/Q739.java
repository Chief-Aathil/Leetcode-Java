import java.util.List;
import java.util.Stack;

public class Q739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            /**
             Add numbers to the stack until a higher num is encountered.
             Then pop every element and set output for each.
             */

            Stack<List<Integer>> stack = new Stack<>();
            int[] out = new int[temperatures.length];

            for(int i=0; i<temperatures.length; i++){
                while(!stack.isEmpty() && stack.peek().get(0)<temperatures[i]){
                    var list = stack.pop();
                    out[list.get(1)]=i-list.get(1);
                }
                stack.push(List.of(temperatures[i],i));
            }
            //Remaining stack elements doesn't have a higher value after them
            while(!stack.isEmpty()){
                out[stack.pop().get(1)] = 0;
            }
            return out;

        }
    }
}
