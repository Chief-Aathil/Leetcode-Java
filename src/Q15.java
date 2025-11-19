import java.util.*;

public class Q15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> output = new ArrayList<>();
            for(int i=0; i<nums.length-2; i++){
                if(nums[i]==0) break;
                if(i>0 && nums[i]== nums[i-1]) continue;

                // For each num find2Sum
                int left=i+1, right= nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right]> -nums[i]) right--;
                    else if(nums[left]+nums[right]< -nums[i]) left++;
                    else {
                        output.add(List.of(nums[i],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;
                    }
                }
            }
            return output;
        }
    }
/**
 -4,-1,-1,0,1,2

 */
}
