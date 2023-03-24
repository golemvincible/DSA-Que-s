package Recursion;

public class SumIndDig {

    static int ans =0;

    public static int util(int n){
        //base condition
        if(n<=9){
            ans=ans+n;
            return ans;
        }
        int digit = n%10;
        ans=ans+digit;
        util(n/10);
        return ans;
    }
    public static void main(String args[]){
        int res = util(210);
        System.out.println(res);
    }

}
