import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Q153 {
    class Solution {
        public int findMin(int[] nums) {
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toCollection(PriorityQueue::new))
                    .poll();

        }
    }
}
