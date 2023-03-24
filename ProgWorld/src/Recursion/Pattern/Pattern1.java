package Recursion.Pattern;

/*
    ****
    ***
    **
    *
 */
public class Pattern1 {
    public static void main(String args[]){
        int r,c;
        int n = 4;
        r = n;
        c = 0;
        pattern1(r,c);
    }
    static void pattern1(int r,int c){
        if(r==0){
            return;
        }

        //making a line
        if(c<r){
            System.out.print("*");
            pattern1(r,c+1);
        }

        //a line has been made

        //changing line
        else{
            System.out.println();
            pattern1(r-1,0);
        }

    }
}
