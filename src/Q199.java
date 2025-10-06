import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q199 {

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
        public List<Integer> rightSideView(TreeNode root) {
            /**
             BFS. Add the right most element in each level to output.
             */

            List<Integer> list = new ArrayList<>();
            if (root == null)
                return list;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int currentLevelCount = queue.size();
                TreeNode node = null ;
                for (int i = 0; i < currentLevelCount; i++) {
                    node = queue.remove();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                list.add(node.val);
            }
            return list;
        }
    }

}
