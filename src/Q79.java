import java.util.ArrayList;
import java.util.List;

public class Q79 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            //iterate through the board till first character is found
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){
                    //recursively call check() of valid neighbours
                    if(board[i][j]==word.charAt(0) && check(board, i, j, word, 0,new ArrayList<>())){
                        return true;
                    }
                }
            }
            return false;
        }

        boolean check(char[][] board, int i, int j, String word,int charIndex, List<Integer> visitedIndices){
            //check for word fully present
            if(word.length()-1 == charIndex) return true;

            //find valid neighbours
            if(i-1>=0 && !isVisited(i-1,j,visitedIndices,board.length)) && board[i-1][j]==word.charAt(charIndex+1)){
                visitedIndices.add((i-1)*board.length + j)
                if(check(board, i-1,j, word, charIndex+1, visitedIndices){
                    return true;
                }
            }
            if(j-1>=0 && !isVisited(i,j-1,visitedIndices,board.length)) && board[i-1][j]==word.charAt(charIndex+1)){
                if(check(board, i-1,j, word, charIndex+1, visitedIndices){
                    return true;
                }
            }

            //call check() on valid neighbours
        }

        boolean isVisited(int i, int j, int[] visitedIndices, int rowLength){
            for(int index: visitedIndices){
                if(index/rowLength == i && index%rowLength == j) retrun true;
            }
            return false;
        }
    }
}
