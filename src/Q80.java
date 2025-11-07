public class Q80 {
//    class Solution {
//        public int removeDuplicates(int[] nums) {
//            int left=0, right=0,k=0, currentNum, currentCount=0;
//            while(left<nums.length-k){
//                currentNum = nums[right];
//
//                //find last valid index(left) of current num and index(right) of next num
//                while(nums[right] == currentNum){
//                    if(currentCount<3){
//                        left++;
//                        k++;
//                    }
//                    currentCount++;
//                    right++;
//                }
//
//                //replace duplicate indices after left with number at right
//                if(currentCount>2){
//                    while(nums)
//                        nums[++left] = nums[right++]
//                }
//
//            }
//        }
//    }
}
