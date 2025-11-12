import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            //Recursively call the same fn with 0-k times of using candidates[0].
            List<List<Integer>> allCombinations = new ArrayList<>();
            List<List<Integer>> inclusiveCombinations = new ArrayList<>();
            List<List<Integer>> exclusiveCombinations = new ArrayList<>();

            //Find combinations that includes first element
            List<Integer> combination = new ArrayList<>();
            int sum =0;
            if(candidates.length==0) return allCombinations;
            while(sum<target){
                combination.add(candidates[0]);
                if(sum==target){
                    inclusiveCombinations.add(combination);
                    break;
                }

                //Use remaining elements to achieve sum
                int[] subArray = Arrays.copyOfRange(candidates,1,candidates.length);
                List<List<Integer>> subCombinations = combinationSum(subArray,target-sum);
                for(var subCombination: subCombinations){
                    List<Integer> comb = new ArrayList<>();
                    comb.addAll(combination);
                    comb.addAll(subCombination);
                    inclusiveCombinations.add(comb);
                }
            }

            //Find combinations that doesn't include first element
            int[] subArray = Arrays.copyOfRange(candidates,1,candidates.length);
            List<List<Integer>> subCombinations = combinationSum(subArray,target);
            for(var subCombination: subCombinations){
                exclusiveCombinations.add(subCombination);
            }

            //Combine
            allCombinations.addAll(inclusiveCombinations);
            allCombinations.addAll(exclusiveCombinations);
            return allCombinations;
        }
    }
}
