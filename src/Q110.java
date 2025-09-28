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
        Map<TreeNode, Integer> heightMap = new HashMap<>();

        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }
            return isBalanced(root.left) && isBalanced(root.right);
        }

        int getHeight(TreeNode node) {
            if (node == null) return 0;
            if (heightMap.containsKey(node)) return heightMap.get(node);
            var leftHeight = getHeight(node.left);
            var rightHeight = getHeight(node.right);
            var height = 1 + Math.max(leftHeight, rightHeight);
            heightMap.put(node, height);
            return height;
        }
    }
}
