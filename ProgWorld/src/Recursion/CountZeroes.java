package Recursion;

public class CountZeroes {
    static int count=0;
    static void countZeroes(int n){
        if(n<=9){
            if(n==0)
                count++;
            return;
        }
        int digit = n%10;
        if(digit==0)
            count++;
        countZeroes(n/10);
    }
    public static void main(String args[]){
        countZeroes(12004010);
        System.out.println(count);
    }
}
