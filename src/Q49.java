import java.util.*;

public class Q49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> stringMap = new HashMap<>();

            for(String str: strs){
                char[]chars= str.toCharArray();
                Arrays.sort(chars);
                String sortedString = new String(chars);
                List<String> strings = stringMap.getOrDefault(sortedString,new ArrayList<String>());
                strings.add(str);
                stringMap.put(sortedString,strings);
            }
            return new ArrayList<>(stringMap.values());
        }
    }
}
