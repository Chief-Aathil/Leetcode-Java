import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q36 {
    public static boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSets = new ArrayList<>();
        List<Set<Character>> columnSets = new ArrayList<>();
        List<Set<Character>> boxSets = new ArrayList<>();
        for(int i = 0 ; i<9 ; i++){
            rowSets.add(new HashSet<>());
            columnSets.add(new HashSet<>());
            boxSets.add(new HashSet<>());
        }
        int k;
        for(int i =0; i< 9; i++){
            for(int j=0; j<9; j++){
                var rowSet = rowSets.get(i);
                var columnSet = columnSets.get(j);
                k = 3*(i/3) + j/3;
                var boxSet = boxSets.get(k);
                char currentElement = board[i][j];
                if(currentElement == '.') continue;
                if(rowSet.contains(currentElement)) {
                    return false;
                }
                rowSet.add(currentElement);
                if(columnSet.contains(currentElement)) {
                    return false;
                }
                columnSet.add(currentElement);
                if(boxSet.contains(currentElement)) {
                    return false;
                }
                boxSet.add(currentElement);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        var out = Q36.isValidSudoku(board);
        System.out.println(out);
    }
}
