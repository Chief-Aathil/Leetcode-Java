import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            //Sort the intervals based on start
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            List<List<Integer>> out = new LinkedList<>();
            for (int i = 0, n = intervals.length; i < n; i++) {
                int start = intervals[i][0];
                int end = intervals[i][1];

                //Merge adjacent intervals with overlap
                while (i + 1 < n && end>=intervals[i+1][0]) {
                    if(end<intervals[i+1][1]){
                        end = intervals[i+1][1];
                    }
                    i++;
                }
                out.add(List.of(start, end));
            }

            //create output array.
            int[][] outArr = new int[out.size()][2];
            for (int i = 0; i < out.size(); i++) {
                outArr[i][0] = out.get(i).get(0);
                outArr[i][1] = out.get(i).get(1);
            }
            return outArr;
        }
    }

}
