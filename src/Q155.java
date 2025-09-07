import java.util.ArrayList;
import java.util.List;

public class Q155 {
    class MinStack {

        int[] elements = new int[30000];
        int[] minAtIndex = new int[30000];
        int top = -1;
        int min = Integer.MAX_VALUE;

        public MinStack() {

        }

        public void push(int val) {
            elements[++top]=val;
            minAtIndex[top] = Math.min(top==0?Integer.MAX_VALUE:minAtIndex[top-1], val);
        }

        public void pop() {
            elements[top--]=Integer.MAX_VALUE;
        }

        public int top() {
            return elements[top];
        }

        public int getMin() {
            return minAtIndex[top];
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
