import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Q637 {

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
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            List<Double> levelAverages = new ArrayList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                double sum = 0.0;
                for (int i = 0; i < levelSize; i++) {
                    var node = queue.remove();
                    sum += node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                levelAverages.add(sum / levelSize);
            }
            return levelAverages;
        }
    }

}
