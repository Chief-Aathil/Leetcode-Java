public class Q3190 {
    class Solution {
        public int minimumOperations(int[] nums) {
            int minOps = 0;
            for(int n: nums){
                if(n%3!=0) minOps++;
            }
            return minOps;
        }
    }
}
