import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Q217 {
    class Solution {

        //Improved Set approach
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int n: nums){
                if(!set.add(n)) return true;
            }
            return false;
        }

//        //Sorting approach.
//        public boolean containsDuplicate(int[] nums) {
//            if(nums.length<2) return false;
//            Arrays.sort(nums);
//            for(int i=0; i<nums.length-1; i++){
//                if(nums[i]==nums[i+1]) return true;
//            }
//            return false;
//        }

//        //Set approach
//        public boolean containsDuplicate(int[] nums) {
//            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
//            return set.size()!=nums.length;
//        }

    }
}
