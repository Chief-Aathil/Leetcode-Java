import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q271 {


    static class Solution {

        public String encode(List<String> strs) {
            String out=strs.isEmpty()?"0":"";
            for(var str: strs){
                out+= str.length()+"#"+str;
            }
            return out;
        }

        public List<String> decode(String str) {
            char[] chars = str.toCharArray();
            List<String> out = new ArrayList<>();
            if(chars[0]=='0') return out;
            int len;
            for(int i=0; i<chars.length; ){
                String s ="";

                //Parse the length
                while(chars[i]!='#'){
                    s+=chars[i];
                    i++;
                }
                i++;
                len = Integer.parseInt(s);
                s="";
                int j=0;
                for(; j<len; j++){
                    s+=chars[i+j];
                }
                out.add(s);
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
