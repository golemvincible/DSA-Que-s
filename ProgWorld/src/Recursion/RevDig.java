package Recursion;

public class RevDig {
    static int res = 0;
    public static void reverseDig(int n){
        if(n<=9){
            int digit = n;
            res = res*10 + digit;
            return;
        }
        int digit = n%10;
        res = res*10 + digit;
        reverseDig(n/10);
    }
    public static void main(String args[]){
        reverseDig(1234);
        System.out.println(res);
    }
}
