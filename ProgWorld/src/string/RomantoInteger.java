package src.string;

//https://leetcode.com/problems/roman-to-integer/
import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public static int romanToInt(String s) {
        int res=0;
        Map<Character,Integer> m = new HashMap<>();
        m.put('E',0);
        m.put('I',1);
        m.put('V',5);
        m.put('X',10);
        m.put('L',50);
        m.put('C',100);
        m.put('D',500);
        m.put('M',1000);
        for(int i=s.length()-1;i>=0;i--){
            char ch1 = s.charAt(i);
            char ch2 = 'E';
            if((i-1)>=0){
                ch2 = s.charAt(i-1);
            }
            int curr = m.get(ch1);
            int prev = m.get(ch2);

            if(curr>prev){
                res+= curr-prev;
                i--;
            }
            else{
                res+= curr;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }
}
