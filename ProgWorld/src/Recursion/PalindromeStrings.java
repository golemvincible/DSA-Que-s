package Recursion;
//program to check whether the given string is palindrome or not
import java.util.Scanner;
public class PalindromeStrings {
    boolean isPalindromeHelper(String s,int l,int r){
        if(l>=r)
            return true;
        if(s.charAt(l)!=s.charAt(r))
            return false;
        return isPalindromeHelper(s,l+1,r-1);
    }
    void isPalindrome(String s){
        if(isPalindromeHelper(s,0,s.length()-1)){
            System.out.println(s +" is palindrome");
        }else{
            System.out.println(s +" is not palindrome");
        }
    }
    public static void main(String args[]){
        PalindromeStrings p = new PalindromeStrings();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        p.isPalindrome(s);
    }
}
