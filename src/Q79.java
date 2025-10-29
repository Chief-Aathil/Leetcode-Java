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
            int index = i*board.length + j;
            int[] indices = new int[]{ index-1, index+1, index-board.length, index+board.length};
            for(int idx: indices){
                int rowIndex= idx/board.length;
                int colIndex= idx % board.length;
                if(isValidIndex(board, rowIndex, colIndex, word, charIndex, visitedIndices)){
                    visitedIndices.add(idx);
                    if(check(board, rowIndex, colIndex, word, charIndex+1, visitedIndices)){
                        return true;
                    }
                    visitedIndices.remove(visitedIndices.size()-1);
                }
            }
            return false;
        }

        boolean isVisited(int i, int j, List<Integer> visitedIndices, int rowLength){
            for(var index: visitedIndices){
                if(index/rowLength == i && index%rowLength == j) return true;
            }
            return false;
        }

        boolean isValidIndex(char[][] board, int i, int j, String word,int charIndex, List<Integer> visitedIndices){
            return i>=0 && i<board.length && j>=0 && j<board.length
                    && board[i][j] == word.charAt(charIndex)
                    && !isVisited(i,j,visitedIndices,board.length);
        }
    }
}
