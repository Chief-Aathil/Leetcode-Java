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
        List<Integer> values = new ArrayList<>();

        public boolean isValidBST(TreeNode root) {
            values = bst(root);
            for (int i = 0, j = 1; j < values.size(); i++, j++) {
                if (values.get(i) >= values.get(j))
                    return false;
            }
            return true;
        }

        List<Integer> bst(TreeNode root) {
            List<Integer> arr = new ArrayList<>();
            if (root.left != null)
                arr.addAll(bst(root.left));
            arr.add(root.val);
            if (root.right != null)
                arr.addAll(bst(root.right));
            return arr;
        }
    }
}
