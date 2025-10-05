import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q102 {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> output = new ArrayList<>();
            if (root == null)
                return output;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> levelNodes = new ArrayList<>();
                int currentSize = queue.size();
                for (int i = 0; i < currentSize; i++) {
                    if (queue.peek().left != null)
                        queue.add(queue.peek().left);
                    if (queue.peek().right != null)
                        queue.add(queue.peek().right);
                    levelNodes.add(queue.remove().val);
                }
                output.add(levelNodes);
            }
            return output;
        }
    }
}
