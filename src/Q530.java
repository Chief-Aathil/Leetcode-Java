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
        int[] min= new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        public int getMinimumDifference(TreeNode root) {
            dfs(root);
            return min[1]- min[0];
        }

        void dfs(TreeNode node){
            if(node==null) return;
            if(node.val<min[0]){
                min[1] = min[0];
                min[0] = node.val;
            }else if(node.val>min[0] && node.val<min[1]){
                min[1] = node.val;
            }
            dfs(node.left);
            dfs(node.right);
        }
    }
}
