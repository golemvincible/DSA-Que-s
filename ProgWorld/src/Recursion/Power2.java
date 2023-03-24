package Recursion;
// find nth power of a number using recursion optimized approach
public class Power2 {
    int pow(int x,int m){
        if(m==0){
            return 1;
        }
        int temp = pow(x,m/2);
        if(m%2==0)
            return temp*temp;
        return temp*temp*x;
    }
    public static void main(String args[]){
        Power2 p = new Power2();
        int y =p.pow(3,5);
        System.out.println(y);
    }
}
