import java.util.ArrayList;
import java.util.List;

public class Q155 {
    class MinStack {
        private Node top;

        private  class Node {
            int val;
            int min;
            Node next;
            Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }

        public MinStack() {
            top = null;
        }

        public void push(int val) {
            if (top == null) {
                top = new Node(val, val, null);
            } else {
                top = new Node(val, Math.min(val, top.min), top);
            }
        }

        public void pop() {
            if (top != null) {
                top = top.next;
            }
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.min;
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
