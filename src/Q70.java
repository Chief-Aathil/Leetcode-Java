import java.util.HashMap;
import java.util.Map;

public class Q70 {
    static class Solution {
        Map<Integer,Integer> map = new HashMap<>();

        public int climbStairs(int n) {
            if(n<3) return n;
            if(map.containsKey(n)) return map.get(n);
            int a= climbStairs(n-2);
            int b = climbStairs(n-1);
            map.put(n,a+b);
            return a+b;
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        var out = obj.climbStairs(44);
        System.out.println(out);

    }
}
