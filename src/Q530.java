import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q530 {

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
        List<Integer> values = new ArrayList<>();
        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            values.sort(Comparator.naturalOrder());
            int minDiff = Integer.MAX_VALUE;
            for(int i=0; i< values.size()-1; i++){
                minDiff=Math.min(minDiff, Math.abs(values.get(i)-values.get(i+1)));
            }
            return minDiff;
        }

        void dfs(TreeNode node){
            if(node==null) return;
            values.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }
}
