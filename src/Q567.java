import java.util.HashMap;
import java.util.Map;

public class Q567 {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            /**
             Create character frequency map of s1.
             Iterate s2 till a matching character is found.
             Expand window right till a non-matching character
             (either different character or freq mismatch)is found or entire s1 is matched.
             Do till end of s2 is in window
             */

            //Create char-freq map of s1
            char[] chars1 = s1.toCharArray();
            Map<Character,Integer> charMap = new HashMap<>();
            for(char c: chars1){
                charMap.put(c,charMap.getOrDefault(c,0)+1);
            }

            //Iterate through s2 till last char in window
            int left=0, right=0;
            while(right<s2.length()){
                //increment left till matching char
                while(left<s2.length() && charMap.get(s2.charAt(left))==null){
                    left++;
                }
                if(left>=s2.length()){
                    return false;
                }

                //Matching char found. Increment right till complete match or unmatch.
                right = left;
                Map<Character, Integer> subStringMap = new HashMap<>();
                while(right<s2.length()){
                    char c = s2.charAt(right);
                    subStringMap.put(c,subStringMap.getOrDefault(c,0)+1);
                    //check for character or freq mismatch
                    if(charMap.get(c)!=null || charMap.get(c)>=subStringMap.get(c)){
                        break;
                    }
                    right++;
                }
                if(s1.length()==right-left+1){
                    return true;
                }else{
                    left = right;
                }

            }
            return false;
        }
    }
}
