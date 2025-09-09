public class Q74 {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
             int m= matrix.length, n= matrix[0].length;
             int left=0, right=(m*n)/2;
             int lValue, rValue;
             while(left!=right && right<m*n){
                 lValue = matrix[left/n][left%n];
                 rValue = matrix[right/n][right%n];
                 if(rValue==target || lValue==target){
                     return true;
                 }else if(target> rValue ){
                     left = right;
                     right = right +((m*n-1 -right)/2 ==0 ? 1:(m*n-1 -right)/2);
                 }else if(target<rValue){
                     if(target>lValue){
                         right = right -((right-left)/2==0?1:(right-left)/2);
                     }else return false;
                 }
             }
             return matrix[right%m][right%n] == target;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testcase1 = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] testcase2 = new int[][]{{1,3,5}};
        int[][] testcase3 = new int[][]{{1,1}};

        var out3 = solution.searchMatrix(testcase3,2);
//        var out2 = solution.searchMatrix(testcase2,5);
//        var out = solution.searchMatrix(testcase1,13);
    }
}
