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
            dfs(root, new int[]{Integer.MIN_VALUE});
            return goodNodeCount;
        }

        void dfs(TreeNode node, int[] prevValues) {
            if (node == null)
                return;
            boolean isCurrentValGreater = true;
            int[] values = new int[prevValues.length + 1];
            for (int i = 0; i < prevValues.length; i++) {
                values[i] = prevValues[i];
                if (prevValues[i] > node.val)
                    isCurrentValGreater = false;
            }
            if (isCurrentValGreater)
                goodNodeCount++;
            values[prevValues.length] = node.val;
            dfs(node.left, values);
            dfs(node.right, values);
        }
    }

}
