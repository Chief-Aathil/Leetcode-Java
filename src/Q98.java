import java.util.ArrayList;
import java.util.List;

public class Q98 {
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
        public boolean isValidBST(TreeNode root) {
            if((root.left!=null && root.left.val>=root.val) ||
                    (root.right!=null && root.right.val<=root.val)) return false;
            return (root.left==null || isValidBST(root.left)) && (root.right==null || isValidBST(root.right));
        }
    }

}
