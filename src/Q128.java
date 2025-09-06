import java.util.HashSet;

public class Q128 {

        public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;

        var set = new HashSet<Integer>();
        //create set of nums
        for(int n : nums){
            set.add(n);
        }

        int max=0,sequenceLength=0;
        for(int n: set){
            //identify start of a sequence
            if(set.contains(n-1)) continue;

            //find the length of the sequence
            sequenceLength=0;
            for(int curr=n; set.contains(curr); curr++,sequenceLength++) ;

            //update max
            max = Math.max(max,sequenceLength);
        }
        return max;
    }

//    public int longestConsecutive(int[] nums){
//        //Create a set from elements
//        var set = new HashSet<Integer>();
//        for(int n: nums){
//            set.add(n);
//        }
//
//        int max=0, currentMax=0;
//        //Itreate through set
//        for(int n: set){
//            if(set.contains(n+1)){
//                currentMax++;
//            }else{
//                max = Math.max(max,currentMax+1);
//                currentMax=0;
//            }
//        }
//        return max;
//    }
}
