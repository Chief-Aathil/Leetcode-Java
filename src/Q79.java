import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q79 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            //Iterate through the board for first character
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (check(board, word, i, j, visited, 0))
                        return true;
                }
            }
            return false;
        }

        //Recursive function
        boolean check(char[][] board, String word, int i, int j, boolean[][] visited, int charIndex) {
            //check if valid index, visited indices, current character match
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                    || visited[i][j] || board[i][j] != word.charAt(charIndex)) {
                return false;
            }

            //check if entire word matched
            if (charIndex == word.length())
                return true;

            //check neighbours
            visited[i][j] = true;
            if (check(board, word, i - 1, j, visited, charIndex + 1) ||
                    check(board, word, i + 1, j, visited, charIndex + 1) ||
                    check(board, word, i, j - 1, visited, charIndex + 1) ||
                    check(board, word, i, j + 1, visited, charIndex + 1))
                return true;
            visited[i][j] = false;
            return false;

        }
    }
}
