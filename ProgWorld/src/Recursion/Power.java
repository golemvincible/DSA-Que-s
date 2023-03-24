package Recursion;
// find nth power of a number using recursion
import java.util.Scanner;
public class Power {
    int pow(int x,int m){
        if(m==1)
            return x;
        int partialAns = pow(x,m-1);
        return x*partialAns;
    }
    public static void main(String[] args){
        Power p = new Power();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter base and power: ");
        int x =sc.nextInt();
        int m =sc.nextInt();
        System.out.println("Your ans is: " + p.pow(x,m));
    }
}
