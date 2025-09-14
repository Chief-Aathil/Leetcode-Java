import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Q347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            /** Populate a maxheap. Elements: [num,freq]. Set freq value as the sorting condition
             */

            //Find frequency of numbers
            Map<Integer,Integer> freqMap = new HashMap<>();
            for(int n : nums){
                freqMap.put(n,freqMap.getOrDefault(n,0)+1);
            }

            //Create max-heap from freqMap
            PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>((a, b)->
                    b.getValue()-a.getValue()
            );
            for(var entry: freqMap.entrySet()){
                heap.add(entry);
            }

            //Take k elements from the max heap and put only the keys in the response
            int[] output = new int[k];
            for(int i=0; i<k; i++){
                output[i]= heap.poll().getKey();
            }
            return output;
        }
    }
}
