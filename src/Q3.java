import java.util.HashMap;
import java.util.Map;

class Q3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If we've seen this character before and its index is within our current window
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                // Move left pointer to position after the previous occurrence
                left = charMap.get(currentChar) + 1;
            }

            // Update the character's position
            charMap.put(currentChar, right);

            // Update max length (current window size is right-left+1)
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

     public int lengthOfLongestSubstringV2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            Character curr = s.charAt(right);
            if (map.get(curr) != null) {
                left = Math.max(left, map.get(curr) + 1);
            }
            max = Math.max(right - left + 1, max);
            map.put(curr, right);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Q3 obj = new Q3();
        var out = obj.lengthOfLongestSubstring("abcabcbb");
        System.out.println(out);
    }
}