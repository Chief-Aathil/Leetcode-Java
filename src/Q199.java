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
        List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {
            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode node, int level) {
            if (node == null)
                return;
            if (res.size() == level) {
                res.add(node.val);
            }
            dfs(node.right, level + 1);
            dfs(node.left, level + 1);
        }
    }
}
