public class Q206 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        static void print(ListNode head) {
            ListNode current = head;
            System.out.print("[");
            while (current.next != null) {
                System.out.print(current.val + ",");
                current = current.next;
            }
            System.out.print(current.val + "]");
        }

    }

    //Iterative method
//    public ListNode reverseList(ListNode head) {
//        ListNode prev, current, nextNode;
//        prev = null;
//        current = head;
//        nextNode = head != null ? head.next : null;
//
//        while (current != null) {
//            current.next = prev;
//            prev = current;
//            current = nextNode;
//            if (nextNode != null) {
//                nextNode = nextNode.next;
//            }
//        }
//        return prev;
//    }

    //Recursive method
    public ListNode reverseList(ListNode node) {
        //handle base case: tail
        if (node == null || node.next == null) {
            return node;
        }
        //handle general case. recursive call
        //set the current node as the last node the reversed list
        ListNode newHead = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;

    }

}
