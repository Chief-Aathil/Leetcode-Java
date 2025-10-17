import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //Sort the intervals based on start
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            List<int[]> out = new ArrayList<>();
            for (int i = 0, n = intervals.length; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                //Merge adjacent intervals with overlap
                while (i + 1 < n && end>=intervals[i+1][0]) {
                    end=Math.max(end, intervals[i+1][1]);
                    i++;
                }
                out.add(new int[]{start, end});
            }
            return out.toArray(new int[out.size()][2]);
        }
    }
}
