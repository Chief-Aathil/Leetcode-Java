public class Q151 {
    class Solution {
        public String reverseWords(String s) {
            //Split the string on ' '
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            for(int i=0; i<chars.length; i++){
                //find start and end indices of word
                while(chars[i++]!=' ' && i<chars.length);
                i--;
                int j=i<chars.length-1? i+1: i;
                for(; j<chars.length && chars[j]!=' '; j++);

                //insert the word to the beginning
                builder.insert(0,new String(Arrays.copyOfRange(chars,i,j+1)));
                i=j;
            }
            return builder.toString();
        }
    }
}
