import java.util.HashSet;
import java.util.Set;

public class Q2154 {
    class Solution {
        public int findFinalValue(int[] nums, int original) {
            Set<Integer> set = new HashSet<>();
            for(int n: nums) set.add(n);
            while(set.contains(original)){
                original*=2;
            }
            return original;
        }
    }
}
