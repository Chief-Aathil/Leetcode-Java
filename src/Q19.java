import org.w3c.dom.ls.LSOutput;

public class Q19 {
    //19. Remove Nth Node From End of List

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

//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode current = head;
//        int size = 1;
//        for (; current.next != null; size++) {
//            current = current.next;
//        }
//        current = head;
//        for (int i = 1; i < size - n; i++) {
//
//            current = current.next;
//        }
//        if (current == head) {
//            head = current.next == null ? null : current.next.next;
//        } else {
//            current.next = current.next.next;
//        }
//        return head;
//    }


    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        //Use a dummy node to handle the case where the head node needs to be removed.
        ListNode start = new ListNode(0,head);
        ListNode fastPointer = start, slowPointer = start ;

        //Offset fastPointer by n nodes ahead of slowPointer. Or till fastPointer reaches tail node
        for(int i=0; i<n; i++){
            fastPointer = fastPointer.next;
        }
        //Move both pointers till fastPointer reach tail
        while(fastPointer.next!=null){
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
       slowPointer.next = slowPointer.next.next;
        return start.next;
    }


    public static void main(String[] args) {
        int[] testcase = {1, 2};
        ListNode head = new ListNode(1, null);
        ListNode current = head;
        for (int i = 1; i < testcase.length; i++) {
            current.next = new ListNode(testcase[i], null);
            current = current.next;
        }
        head.print(head);
        var newHead = Q19.removeNthFromEnd(head, 1);
        ListNode.print(newHead);

    }
}
