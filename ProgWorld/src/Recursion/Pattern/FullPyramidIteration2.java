package Recursion.Pattern;

public class FullPyramidIteration2 {
    public static void main(String[] args) {
        int row=5;
        int col=2*row-1;
        for(int i=0;i<row;i++){
            for(int m=0;m<col;m++){
                if(m>=col/2-i && m<=col/2+i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
