import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q138 {
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

    class Solution {
        public Node copyRandomList(Node head) {
            /**
             Iterate original list 2 times.
             1st pass: to create copy. 2nd pass to set the random pointers
             */

            Node ptr = head;
            Node preHead = new Node(0), ptrCopy = preHead;
            Map<Node,Integer> nodeIndexMap = new HashMap<>();
            List<Node> newNodes = new ArrayList<>();
            for(int i=0; ptr!=null; i++){
                var newNode= new Node(ptr.val);
                nodeIndexMap.put(ptr,i);
                newNodes.add(newNode);
                ptrCopy.next = newNode;
                ptrCopy = ptrCopy.next;
                ptr=ptr.next;
            }
            ptrCopy.next = null;

            //Setting random pointer
            ptrCopy= preHead.next;
            ptr=head;
            while(ptr!=null){
                ptrCopy.random = nodeIndexMap.get(ptr.random)!=null
                        ? newNodes.get(nodeIndexMap.get(ptr.random))
                        : null;
                ptr= ptr.next;
                ptrCopy= ptrCopy.next;
            }
            return preHead.next;
        }
    }
}
