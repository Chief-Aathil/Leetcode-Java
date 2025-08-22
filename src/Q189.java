import java.util.Arrays;

public class Q189 {
    public void rotate(int[] nums, int k) {
        int[] numsCopy = Arrays.copyOf(nums,nums.length);
        int n = nums.length;
        for(int i=0; i<n; i++){
            nums[(i+k)%n] = numsCopy[i];
        }
    }
}
