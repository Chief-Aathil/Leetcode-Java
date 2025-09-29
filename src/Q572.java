public class Q572 {

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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) return true;
            if (root != null && subRoot == null || root == null && subRoot != null) return false;
            var isCurrentRootsMatch = dfs(root, subRoot);
            return isCurrentRootsMatch || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        boolean dfs(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) return true;
            if (root != null && subRoot == null || root == null && subRoot != null) return false;
            if (root.val != subRoot.val) return false;
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
    }
}
