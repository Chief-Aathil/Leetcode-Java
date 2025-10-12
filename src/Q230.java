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
        List<Integer> list = new ArrayList<>();
        public int kthSmallest(TreeNode root, int k) {
            traverse(root);
            return list.get(k-1);
        }

        void traverse(TreeNode node) {
            if(node.left!=null) traverse(node.left);
            list.add(node.val);
            if(node.right!=null) traverse(node.right);
        }
    }
}
