public class Q1448 {

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
        int goodNodeCount = 0;

        public int goodNodes(TreeNode root) {
            dfs(root, Integer.MIN_VALUE);
            return goodNodeCount;
        }

        void dfs(TreeNode node, int currentGreatest) {
            if (node == null)
                return;
            if (node.val >= currentGreatest)
                goodNodeCount++;
            currentGreatest = Math.max(currentGreatest, node.val);
            dfs(node.left, currentGreatest);
            dfs(node.right, currentGreatest);
        }
    }
}
