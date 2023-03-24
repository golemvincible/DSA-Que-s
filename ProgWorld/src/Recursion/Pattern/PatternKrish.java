/*
    1        1
   212
  32123
 4321234
543212345
 */
package Recursion.Pattern;
import java.util.Scanner;
public class PatternKrish {
    public static void main(String[] args) {
        int row=5;
        int col=2*row-1;
        for(int i=0;i<row;i++){

            int count=i+1;
            for(int m=0;m<col;m++){

                if(m>=col/2-i && m<=col/2+i){
                    if(m<col/2) {
                        System.out.print(count);
                        count--;
                    }else if(m==col/2){
                        System.out.print(count);
                        count++;
                    }
                    else{
                        System.out.print(count);
                        count++;
                    }
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
