import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q153 {
    class Solution {
        public int findMin(int[] nums) {
            //binary search: compare middle with left and right
            int left = 0, right=nums.length-1,mid,smallest=nums[0];
            int currentSmallest=smallest;
            while(left<right){
                mid= (left+right)/2;
                int prev = nums[left];
                int next = nums[right];
                currentSmallest=Math.min(Math.min(prev,next),nums[mid]);
                if(smallest<currentSmallest)break;
                smallest = currentSmallest;

                if(smallest==prev || smallest == nums[mid]){
                    right=mid-1;
                }else if(smallest==next){
                    left=mid+1;
                }
            }
            return smallest;
        }
    }

}
