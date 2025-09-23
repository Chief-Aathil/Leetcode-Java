import java.util.ArrayList;
import java.util.List;

public class Q143 {

    class Solution {
    public void reorderList(ListNode head) {
        /**
         Create array of nodes. Reconstruct the list. Use the array index to fetch the node quickly
         */

        //Construct array
        List<ListNode> list = new ArrayList<>();
        var ptr = head;
        while(ptr!=null){
            list.add(ptr);
            ptr=ptr.next;
        }
        if(list.size()<3) return;

        //Reconstruct the linked list using array
        ptr=head;
        for(int i=0; i<list.size()/2 ; i++){
            var nodeFromEnd = list.get(list.size()-1-i);
            var nextNode = ptr.next;
            ptr.next = nodeFromEnd;
            nodeFromEnd.next = nextNode;
            ptr = nextNode;
        }
        ptr.next = null;
    }
}

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}


