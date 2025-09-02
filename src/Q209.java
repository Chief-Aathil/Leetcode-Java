import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, right=0, sum=0, min=0;
        //iterate till last element in window and sum<target
        while( right<nums.length || sum>=target){
            //increase window till sum>=target
            while(sum<target && right<nums.length){
                sum+=nums[right++];
            }
            // 2,3,1,2,4,3
            // l       r
            min = right - left;

            //decrease window till sum<target
            while(sum>=target){
                sum-=nums[left++];
            }
            min = Math.min(min,right - left);
            // right--;
            // left--;

        }
        return min;
    }


}
