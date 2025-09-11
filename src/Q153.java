import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q153 {
    class Solution {
        public int findMin(int[] nums) {
            //binary search: compare middle with right only
            int left = 0, right=nums.length-1,mid;
            while(left<right){
                mid= (left+right)/2;
                if(nums[mid]>nums[right]){
                    left = mid+1;
                }else{
                    right = mid;
                }
            }
            return nums[right];
        }
    }
}
