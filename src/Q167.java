import java.util.HashMap;
import java.util.Map;

public class Q167 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            Map<Integer,Integer> map = new HashMap<>();

            for(int i=0;i<numbers.length;i++){
                //check if compliment present in map
                if(map.containsKey(target-numbers[i])){
                    return new int[]{map.get(target-numbers[i]), i+1};
                }

                //Add current element to hashmap
                map.put(numbers[i],i+1);
            }
            return null;
        }
    }
}
