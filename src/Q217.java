import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Q217 {
    class Solution {

        //Sorting approach.
        public boolean containsDuplicate(int[] nums) {
            if(nums.length<2) return false;
            Arrays.sort(nums);
            for(int i=0; i<nums.length-1; i++){
                if(nums[i]==nums[i+1]) return true;
            }
            return false;
        }

//        //Set approach
//        public boolean containsDuplicate(int[] nums) {
//            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//            return set.size()!=nums.length;
//        }

    }
}
