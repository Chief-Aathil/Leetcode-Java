import java.util.*;
import java.util.stream.Collectors;

public class Q27 {
    public int removeElement(int[] nums, int val) {
       
        Set<Integer> set = new HashSet<>();
        for(int i =0; i< nums.length; i++){
            set.add(nums[i]);
        }
        set.remove(val);
        int k = set.size();
        List<Integer> list = new ArrayList<>(set);
        for(int i=0;i<k;i++){
            nums[i] = list.get(i);
        }
        return k;
    }

    public static void main(String[] args) {
        var obj = new Q27();
        int[] nums = {3,2,2,3};
        int val = 3;
        int out = obj.removeElement(nums, val);

        System.out.println(Arrays.toString(nums));
        System.out.println(out);


    }
}
