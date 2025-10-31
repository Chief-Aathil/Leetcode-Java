import java.util.Arrays;

public class Q151 {
    class Solution {
        public String reverseWords(String s) {
            //Split the string on ' '
            String[] words = s.trim().split(" +");
            StringBuilder builder = new StringBuilder();

            //Add words in reverse order
            for(int i=words.length-1; i>=0; i--){
                builder.append(words[i]);
                if(i>0) builder.append(" ");
            }
            return builder.toString();
        }
    }
}
