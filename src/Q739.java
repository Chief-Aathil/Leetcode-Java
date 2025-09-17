import java.util.Stack;

public class Q739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            /**
             Add numbers to the stack until a higher num is encountered.
             Then pop every element add set output for each.
             */

            Stack<Integer> stack = new Stack<>();
            int[] out = new int[temperatures.length];

            for(int i=0; i<temperatures.length; i++){
                while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                    var index = stack.pop();
                    out[index]=i-index;
                }
                stack.push(i);
            }

            //Remaining elements doesn't have a larger value to right.
            while(!stack.isEmpty()){
                out[stack.pop()] = 0;
            }
            return out;

        }
    }
}
