import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q15 {
    class Solution {
        Map<Integer, List<Integer>> numToIndicesMap = new HashMap<>();

        public List<List<Integer>> threeSum(int[] nums) {
            //Create a map<number:index>
            for(int i=0; i<nums.length; i++){
                numToIndicesMap.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
            }

            //For each num find 2Sum = -num
            List<List<Integer>> output = new ArrayList<>();
            for(int i=0;i<nums.length; i++){
                List<List<Integer>> twoSumCombinations = find2Sum(nums, -nums[i], i);
                if(twoSumCombinations==null || twoSumCombinations.size()==0){
                    continue;
                }
                for(var combination: twoSumCombinations){
                    combination.add(i);
                    combination.sort(null);
                    boolean isTripletAlreadyPresent = false;
                    for(var entry: output){
                        if(entry.get(0)==combination.get(0)
                                && entry.get(1)==combination.get(1)
                                && entry.get(2)==combination.get(2)){
                            isTripletAlreadyPresent = true;
                        }
                    }
                    if(isTripletAlreadyPresent){
                        continue;
                    }
                    output.add(combination);
                }

            }
            return output;

        }

        List<List<Integer>> find2Sum(int[] nums, int target, int excludedIndex) {
            List<List<Integer>> twoSumIndices = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i == excludedIndex) {
                    continue;
                }
                var indices = numToIndicesMap.get(target - nums[i]);
                if (indices == null || indices.size() == 0) {
                    continue;
                }
                for (int index : indices) {
                    if (index == excludedIndex) {
                        continue;
                    }
                    twoSumIndices.add(new ArrayList<>(List.of(i, index)));
                }

            }
            return twoSumIndices;
        }

    }
}
