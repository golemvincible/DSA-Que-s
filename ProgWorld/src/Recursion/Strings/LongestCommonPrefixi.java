package src.Recursion.Strings;
//https://leetcode.com/problems/longest-common-prefix/
//approach 1
public class LongestCommonPrefixi{
    private static String longestCommonPrefix(String[] strs) {
        String prev = strs[0];

        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            while(str.indexOf(prev)!=0){
                prev=prev.substring(0,prev.length()-1);
            }
        }
        return prev;
    }
    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
