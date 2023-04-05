package src.string;

public class LongestPalindromicSubstring {
    /*
        ind will store 1st index of longest substring
        maxLen will store length of longest substring
    */
    private static int start=-1,maxLen=Integer.MIN_VALUE;

    public static String longestPalindrome(String s) {
        if(s.length()==1)
            return s;

        for(int i=0;i<s.length()-1;i++){

            /*
                assume odd length, try to extend Palindrome as possible.
                example "aba"
                for each character we will try out even and odd combinations for
                palindrome
            */
            extendPalindrome(s,i,i);

            //even string "abba"
            extendPalindrome(s,i,i+1);
        }
        return s.substring(start,start+maxLen);
    }
    private static void extendPalindrome(String s,int j,int k){
        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        int len = k-j-1;
        if(len>maxLen){
            maxLen=len;
            start=j+1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
