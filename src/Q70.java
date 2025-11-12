import java.util.HashMap;
import java.util.Map;

public class Q70 {
    class Solution {
        Map<Integer,Integer> map = new HashMap<>();

        public int climbStairs(int n) {
            if(n<3) return n;
            if(map.containsKey(n)) return map.get(n);
            int a,b;
            if(map.containsKey(n-2)){
                b= map.get(n-2);
            }else{
                b= climbStairs(n-2);
                map.put(n-2,b);
            }
            if(map.containsKey(n-1)){
                a=map.get(n-1);
            }else{
                a=climbStairs(n-1);
                map.put(n-1,a);
            }
            return a+b;
        }
    }
}
