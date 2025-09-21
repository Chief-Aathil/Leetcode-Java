import java.util.HashMap;
import java.util.Map;

public class Q424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            /**
             Dynamic sliding window with atmost k+1 distinct elements.
             Max window size is the output.
             */

            char[] chars = s.toCharArray();
            int left=0,right=1,max=1;
            Map<Character,Integer> charMap = new HashMap<>();
            charMap.put(chars[left],1);
            while(right<chars.length){
                if(chars[left]!=chars[right]){
                    charMap.put(chars[right],charMap.getOrDefault(chars[right],0)+1);
                }
                right++;

                if(charMap.size()>k+1){
                    if(charMap.get(chars[left])==1){
                        charMap.remove(chars[left]);
                    }
                    left++;
                }
                max=Math.max(max,right-left);
            }
            return max;
        }
    }
}
