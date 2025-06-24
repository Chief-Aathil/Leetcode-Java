import java.util.*;

public class Q13 {

    static List<Character> precedence = List.of('M','D','C','L','X','V','I');
    static final Map<Character,Integer> romanToDecimalMap = Map.of(
            'M',1000,
            'D',500,
            'C',100,
            'L',50,
            'X',10,
            'V',5,
            'I',1
    );
    public int romanToInt(String s) {
        Integer sum=0;
        for(int i =0; i< s.length(); i++){
            Character currentChar = s.charAt(i);
            Integer value = romanToDecimalMap.get(currentChar);
            boolean shouldAdd = i+1 == s.length() || precedence.indexOf(currentChar)<=precedence.indexOf(s.charAt(i+1));
            sum = shouldAdd==true ? sum+value: sum-value;

        }
        return sum;
    }


    public static void main(String[] args) {
        var a = new Q13();
        System.out.println(a.romanToInt("III"));
        System.out.println(a.romanToInt("IV"));
        System.out.println(a.romanToInt("IX"));
    }
}
