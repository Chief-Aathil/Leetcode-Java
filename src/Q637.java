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
            while(!queue.isEmpty()){
                int levelSize = queue.size();
                double sum = 0.0;
                for(int i =0; i< levelSize; i++){
                    sum+=queue.peek().val;
                    queue.offer(queue.peek().left);
                    queue.offer(queue.peek().right);
                    queue.remove();
                }
                levelAverages.add(sum/levelSize);
            }
            return levelAverages;
        }
    }

}
