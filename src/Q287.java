public class Q287 {


}
class Solution {
    public int findDuplicate(int[] nums) {
        /**
         Sum(nums) = n(n+1)/2 +duplicate num
         */

        //All nums same case:
        if(nums.length<3 || nums[0]==nums[1]){
            return nums[0];
        }

        int sum =0, n = nums.length-1;
        for(int num: nums){
            sum+=num;
        }
        return sum-((n*(n+1))/2);
    }
}