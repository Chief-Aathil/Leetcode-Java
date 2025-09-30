import java.util.ArrayList;
import java.util.List;

public class Q235 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            /**
             Binary search till we find both p and q.
             Then compare the paths. Deepest point of similarity is the LCA.
             */

            List<TreeNode> pathToP = getPathToNode(root, p);
            List<TreeNode> pathToQ = getPathToNode(root, q);
            TreeNode lca = pathToP.get(0);
            for (int i = 0; i < pathToP.size() && i < pathToQ.size(); i++) {
                if (pathToP.get(i) == pathToQ.get(i)) lca = pathToP.get(i);
            }
            return lca;
        }

        List<TreeNode> getPathToNode(TreeNode root, TreeNode node) {
            List<TreeNode> path = new ArrayList<>();
            TreeNode ptr = root;
            path.add(ptr);
            while (ptr != node) {
                if (node.val < ptr.val) {
                    ptr = ptr.left;
                } else {
                    ptr = ptr.right;
                }
                path.add(ptr);
            }
            return path;
        }
    }
}
