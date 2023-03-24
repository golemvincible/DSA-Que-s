package Recursion.Pattern;

public class Pattern2 {
    public static void main(String args[]){
        int r,c;
        int n=4;
        r=n;
        c=0;
        pattern2(r,c);
    }
    static void pattern2(int r,int c){
        if(r==0)
            return;

        //printing a line till c reaches r
        if(c<r){
            pattern2(r,c+1);
            System.out.print("*");
        }

        //changing line and printing for next line as c has reached r
        else{
            pattern2(r-1,0);
            System.out.println();
        }
    }
}
