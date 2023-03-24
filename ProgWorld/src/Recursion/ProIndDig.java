package Recursion;

public class ProIndDig {
    static int ans =1;

    public static int util(int n){
        //base condition
        if(n<=9){
            ans=ans*n;
            return ans;
        }
        int digit = n%10;
        ans=ans*digit;
        util(n/10);
        return ans;
    }
    public static void main(String args[]){
        int res = util(2569);
        System.out.println(res);
    }

}
