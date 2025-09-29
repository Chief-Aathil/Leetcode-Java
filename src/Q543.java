public class Q543 {

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

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) return 0;
            var currentDiameter = maxDepth(root.left) + maxDepth(root.right);
            var leftDiameter = diameterOfBinaryTree(root.left);
            var rightDiameter = diameterOfBinaryTree(root.right);
            return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
        }

        private int maxDepth(TreeNode node) {
            if (node == null) return 0;
            return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
        }
    }
}
