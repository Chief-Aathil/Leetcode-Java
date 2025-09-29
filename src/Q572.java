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
            String subTreeString = serialize(subRoot);
            String mainTreeString = serialize(root);
            return mainTreeString.contains(subTreeString);
        }

        String serialize(TreeNode node){
            if(node == null) return "#N";
            return "#" + node.val + ","+ serialize(node.left)+","+serialize(node.right);
        }
    }
}
