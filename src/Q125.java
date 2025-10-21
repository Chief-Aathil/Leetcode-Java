public class Q125 {
    class Solution {
        public boolean isPalindrome(String s) {
            /**
             Use 2 pointers to check from left and right.
             Only consider alphanumeric characters
             */

            for(int left=0, right=s.length()-1; left<right; left++,right--){
                while(!isAlphaNumeric(s.charAt(left)) && left<right) left++;
                while(!isAlphaNumeric(s.charAt(right)) && left<right) right--;
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            }
            return true;
        }

        boolean isAlphaNumeric(char c){
            return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
        }
    }
}
