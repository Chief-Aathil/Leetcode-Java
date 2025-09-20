import java.util.ArrayList;
import java.util.List;

public class Q22 {
    static class Solution {

        public List<String> generateParenthesis(int n) {
            /**
             DFS on binary tree
             */

            List<String> out = new ArrayList<>();
            List<Character> charList = new ArrayList<>(List.of('('));
            dfs(out, charList, n,1,0);
            return out;
        }

        void dfs(List<String> out, List<Character> list, int n,int leftCount, int rightCount) {
            if (leftCount >= n && rightCount >= n) {
                StringBuilder strBuilder = new StringBuilder();
                for (var c : list) {
                    strBuilder.append(c);
                }
                out.add(strBuilder.toString());
                return;
            }

            if (leftCount < n) {
                list.add('(');
                dfs(out,new ArrayList<>(list), n,leftCount+1, rightCount);
                list.remove(list.size()-1);
            }
            if (rightCount < n && leftCount>rightCount) {
                list.add(')');
                dfs(out,new ArrayList<>(list), n, leftCount, rightCount+1);
                list.remove(list.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        Solution obj = new Solution();
        var out = obj.generateParenthesis(3);
    }
}
