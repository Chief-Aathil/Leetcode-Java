import java.util.Stack;

public class Q150 {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            //iterate through the tokens
            for (String token : tokens) {
                //if operator encountered, pop last two elements, evaluate, push back to stack
                if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    int b = stack.pop();
                    int a = stack.pop();
                    switch (token) {
                        case "+" -> stack.push(a + b);
                        case "-" -> stack.push(a - b);
                        case "*" -> stack.push(a * b);
                        case "/" -> stack.push(a / b);
                    }
                } else {
                    //add each element to stack
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = {"2","1","+","3","*"};
        int result = solution.evalRPN(tokens);
        System.out.println(result);
    }
}
