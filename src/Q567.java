import java.util.HashMap;
import java.util.Map;

public class Q567 {

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if(s1.length()>s2.length()) return false;
            Map<Character, Integer> s1Map = new HashMap<>();
            Map<Character, Integer> windowMap = new HashMap<>();

            //Build s1char map and windowMap
            for (int i = 0; i < s1.length(); i++) {
                s1Map.put(s1.charAt(i),s1Map.getOrDefault(s1.charAt(i),0)+1);
                windowMap.put(s2.charAt(i),windowMap.getOrDefault(s2.charAt(i),0)+1);
            }

            //Slide window
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if(s1Map.equals(windowMap))
                    return true;
                var leftChar = s2.charAt(i);
                var rightChar = s2.charAt(s1.length()+i);

                windowMap.put(rightChar,windowMap.getOrDefault(rightChar,0)+1);
                windowMap.put(leftChar,windowMap.get(leftChar)-1);
                if(windowMap.get(leftChar)==0){
                    windowMap.remove(leftChar);
                }
            }
            return s1Map.equals(windowMap);
        }
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        var out = obj.checkInclusion("adc","dcda");
        System.out.println(out);
    }
}