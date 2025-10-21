public class Q125 {
    class Solution {
        public boolean isPalindrome(String s) {
            /**
             Use 2 pointers to check from left and right.
             Only consider alphanumeric characters
             */

            char[] chars = s.toLowerCase().toCharArray();
            for(int left=0, right=chars.length-1; left<right; left++,right--){
                while(!isAlphaNumeric(chars[left]) && left<right) left++;
                while(!isAlphaNumeric(chars[right]) && left<right) right--;
                if(chars[left]!=chars[right]) return false;
            }
            return true;
        }

        boolean isAlphaNumeric(char c){
            return (c>='a' && c<='z') || (c>='0' && c<='9');
        }
    }
}
