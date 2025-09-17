import java.util.ArrayDeque;
import java.util.Deque;

public class Q739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            /**
             Add numbers to the stack until a higher num is encountered.
             Then pop every element add set output for each.
             */

            Deque<Integer> stack = new ArrayDeque<>();
            int[] out = new int[temperatures.length];

            for(int i=0; i<temperatures.length; i++){
                while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                    var index = stack.pop();
                    out[index]=i-index;
                }
                stack.push(i);
            }
            return out;

        }
    }
}
