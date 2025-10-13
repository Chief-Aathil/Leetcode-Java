import java.util.Arrays;

public class Q106 {
    class TreeNode {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if(preorder.length ==0 ) return null;
            TreeNode root = new TreeNode(preorder[0]);

            //Find index of root in inorder
            int inorderRootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == preorder[0]) {
                    inorderRootIndex = i;
                    break;
                }
            }

            //build left subtree
            if (inorderRootIndex > 0) {
                int[] inorderLeft = Arrays.copyOfRange(inorder, 0, inorderRootIndex);
                int[] preorderLeft = Arrays.copyOfRange(preorder, 1, inorderRootIndex + 1);
                root.left = buildTree(preorderLeft, inorderLeft);
            }

            //build right subtree
            if (inorderRootIndex + 1 < inorder.length) {
                int[] inorderRight = Arrays.copyOfRange(inorder, inorderRootIndex, inorder.length);
                int[] preorderRight = Arrays.copyOfRange(preorder, inorderRootIndex + 1, preorder.length);
                root.right = buildTree(preorderRight, inorderRight);
            }
            return root;
        }
    }
}
