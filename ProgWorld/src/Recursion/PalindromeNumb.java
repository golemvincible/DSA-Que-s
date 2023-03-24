package Recursion;

public class PalindromeNumb {
    static int rev=0;
    public static void revNum(int num){
        //base condition
        if(num<=9){
            rev = rev*10 + num;
            return;
        }
        //digit
        int digit = num%10;

        //number
        rev = rev*10 + digit;

        //number update
        revNum(num/10);

    }
    public static void main(String args[]){
        int num = 1221;
        revNum(num);
        if(num==rev){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }

    }
}
