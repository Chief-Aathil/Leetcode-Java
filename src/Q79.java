import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q79 {
    public  record Pair(Integer i, Integer j){};
    class Solution {
        public boolean exist(char[][] board, String word) {
            Set<Pair> visited = new HashSet<>();
            //Iterate through the board for first character
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    if(check(board, word, i, j, visited)) return true;
                }
            }
            return false;
        }

        //Recursive function
        boolean check(char[][] board, String word, int i, int j, Set<Pair> visited) {
            //check if valid index, visited indices, current character match
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                    || visited.contains(new Pair(i, j)) || board[i][j] != word.charAt(visited.size())) {
                return false;
            }

            //check if entire word matched
            if (word.length() == visited.size() + 1)
                return true;

            //check neighbours
            visited.add(new Pair(i, j));
            if (check(board, word, i - 1, j, visited) ||
                    check(board, word, i + 1, j, visited) ||
                    check(board, word, i, j - 1, visited) ||
                    check(board, word, i, j + 1, visited))
                return true;
            visited.remove(new Pair(i, j));
            return false;

        }
    }
}
