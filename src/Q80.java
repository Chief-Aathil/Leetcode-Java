public class Q80 {
    class Solution {
        public int removeDuplicates(int[] nums) {
            int k=0;
            for(int i=0; i<nums.length; i++){
                if(i<2 || nums[i]!=nums[k-2]){
                    nums[k++] = nums[i];
                }
            }
            return k;
        }
    }
}
