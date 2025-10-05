import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q271 {


    static class Solution {

        public String encode(List<String> strs) {
            StringBuilder out= new StringBuilder();
            if(strs.isEmpty()) return out.toString();
            for(var str: strs){
                out.append(str.length()).append("#").append(str);
            }
            return out.toString();
        }

        public List<String> decode(String str) {
            char[] chars = str.toCharArray();
            List<String> out = new ArrayList<>();
            int len;
            for(int i=0; i<chars.length; ){
                StringBuilder strBuilder = new StringBuilder();

                //Parse the length
                while(chars[i]!='#'){
                    strBuilder.append(chars[i]);
                    i++;
                }
                i++;
                len = Integer.parseInt(strBuilder.toString());
                strBuilder = new StringBuilder();
                int j=0;
                for(; j<len; j++){
                    strBuilder.append(chars[i + j]);
                }
                out.add(strBuilder.toString());
                i=i+j;
            }
            return out;
        }
    }


    public static void main(String[] args) {
        Solution obj = new Solution();
        List<String> inp = List.of("neet", "code", "love", "you");
        var out = obj.encode(inp);
        System.out.println(out);
        var out2 = obj.decode(out);
    }
}
