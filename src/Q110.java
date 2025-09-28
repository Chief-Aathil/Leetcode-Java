import java.util.HashMap;
import java.util.Map;

public class Q110 {

    public static class TreeNode {
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
        record BoolInt(boolean isBalanced, int height){};
        public boolean isBalanced(TreeNode root) {
            return dfs(root).isBalanced();
        }

        public BoolInt dfs(TreeNode node){
            if(node == null) return new BoolInt(true,0);
            var left = dfs(node.left);
            var right = dfs(node.right);
            var height = 1 + Math.max(left.height,right.height);
            var isBalanced = left.isBalanced() && right.isBalanced()
                    && Math.abs(left.height - right.height)<2;
            return new BoolInt(isBalanced,height);
        }
    }
}
