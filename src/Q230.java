import java.util.ArrayList;
import java.util.List;

public class Q230 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = traverse(root);
            return list.get(k-1);
        }

        List<Integer> traverse(TreeNode node) {
            List<Integer> list = new ArrayList<>();
            if(node.left!=null) list.addAll(traverse(node.left));
            list.add(node.val);
            if(node.right!=null) list.addAll(traverse(node.right));
            return list;
        }

    }
}
