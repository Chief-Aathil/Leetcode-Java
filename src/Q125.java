public class Q125 {
    class Solution {
        public boolean isPalindrome(String s) {
            /**
             Use 2 pointers to check from left and right.
             Only consider alphanumeric characters
             */

            for(int left=0, right=s.length()-1; left<right; left++,right--){
                while(!Character.isLetterOrDigit(s.charAt(left)) && left<right) left++;
                while(!Character.isLetterOrDigit(s.charAt(right)) && left<right) right--;
                if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            }
            return true;
        }
    }
}
