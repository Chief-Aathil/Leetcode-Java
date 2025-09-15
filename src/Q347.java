import java.util.*;

public class Q347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            /**
             Populate an inverted frequence map.
             Give the top k elements from this
             */

            //Create a map of n:freq
            Map<Integer, Integer> freqMap = new HashMap<>();
            for(int n: nums){
                freqMap.put(n,freqMap.getOrDefault(n,0)+1);
            }

            //Create a frequency bucket[freq:[nums that have freq]]
            List<Set<Integer>>freqBuckets = new ArrayList<>(nums.length);//optimize size
            for(int i=0; i<nums.length; i++){
                freqBuckets.add(new HashSet<>());
            }
            for(var entry: freqMap.entrySet()){
                var set = freqBuckets.get(entry.getValue()-1);
                set.add(entry.getKey());
                freqBuckets.set(entry.getValue()-1,set);
            }

            //Take last k elements from freqBucket
            int[] out = new int[k];
            for(int i=0,j=freqBuckets.size()-1;i<k;j--){
                var set = freqBuckets.get(j);
                if(set.isEmpty()) continue;
                for(var e: set){
                    out[i++] = e;
                }
            }
            return out;

        }
    }
}
