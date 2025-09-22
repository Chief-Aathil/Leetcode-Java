import java.util.HashMap;
import java.util.Map;

public class Q424 {
    class Solution {
        public int characterReplacement(String s, int k) {
            /**
             Dynamic sliding window. Max window size where count of non-dominant characters<=k
             */
            int left=0, right=0,max=0;
            Map<Character,Integer> charMap = new HashMap<>();
            char[] chars = s.toCharArray();
            while(right<s.length()){
                charMap.put(chars[right],charMap.getOrDefault(chars[right],0)+1);
                right++;

                //Find dominant-character:
                int dominantCharCount =0;
                for(int i=left; i<right; i++){
                    dominantCharCount = Math.max(dominantCharCount,charMap.get(chars[i]));
                }

                //Check if non-dominant character count<=k
                if(right-left -dominantCharCount >k){
                    charMap.put(chars[left], charMap.get(chars[left])-1);
                    left++;
                }else{
                    max=Math.max(max,right-left);
                }
            }
            return max;
        }
    }
}
