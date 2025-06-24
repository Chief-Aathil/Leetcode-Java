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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int size = 1;
        for (; current.next != null; size++) {
            current = current.next;
        }
        current = head;
        for (int i = 1; i < size - n; i++) {

            current = current.next;
        }
        if (current == head) {
            head = current.next == null ? null : current.next.next;
        } else {
            current.next = current.next.next;
        }
        return head;
    }


//    public static  ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode fastPointer = head, slowPointer = head;
//
//        //Offset fastPointer by n nodes ahead of slowPointer. Or till fastPointer reaches tail node
//        for(int i=0; i<n && fastPointer.next!=null; i++){
//            fastPointer = fastPointer.next;
//        }
//        //Move both pointers till fastPointer reach tail
//        while(fastPointer.next!=null){
//            fastPointer = fastPointer.next;
//            slowPointer = slowPointer.next;
//        }
//        //case: remove head node
//        if(slowPointer == head ) {
//            if (fastPointer == head) {
//                //head -> 0(s,f) -> null
//                head = null;
//            }else{
//                // head -> 0s ->..f..->null
//                head = slowPointer.next;
//            }
//        }else {
//            slowPointer.next = slowPointer.next.next;
//        }
//        return head;
//    }


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
