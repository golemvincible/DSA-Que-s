package src.Recursion.Strings;

import java.util.Arrays;

//approach 2
public class LongestCommonPrefixii {
    private static String longestCommonPrefix(String[] strs) {
        if(strs.length==1)
            return strs[0];
        //this will give us most different character string at the end
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length-1];
        //we have sorted string array so we know first length is smaller or equal to last length
        int i=0;
        while(i<first.length() && first.charAt(i)==last.charAt(i)){
            i++;
        }
        return first.substring(0,i);
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
