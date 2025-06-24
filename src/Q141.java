import java.util.HashSet;
import java.util.Set;

public class Q141 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        public boolean hasCycle(ListNode head) {
            ListNode current = head;
            Set<ListNode> nodeSet = new HashSet<>();
            while (current != null && current.next != null) {
                if (nodeSet.contains(current)) {
                    return true;
                }
                nodeSet.add(current);
                current = current.next;
            }
            return false;
        }

//        public static void main(String[] args) {
//            int[] values
//            ListNode list = new ListNode();
//
//        }
    }


}
