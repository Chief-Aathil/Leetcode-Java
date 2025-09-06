import java.util.HashSet;

public class Q128 {

    public int longestConsecutive(int[] nums){
        //Create a set from elements
        var set = new HashSet<Integer>();
        for(int n: nums){
            set.add(n);
        }

        int max=0, currentMax=0;
        //Itreate through set
        for(int n: set){
            if(set.contains(n+1)){
                currentMax++;
            }else{
                max = Math.max(max,currentMax+1);
                currentMax=0;
            }
        }
        return max;
    }
}
