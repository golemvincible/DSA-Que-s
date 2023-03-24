package Recursion.Pattern;

public class PatternKrish2 {
    public static void main(String[] args) {
        int row = 8;
        int col = row;
        for (int i = 0; i < row; i++) {
            int m=i,n=col-1-i;
            for (int j = 0; j < col; j++) {
                    if(i<=(col/2)-1){
                        if(j>m && j<n){
                            System.out.print(" ");
                        }else{
                            System.out.print("*");
                        }
                    }
                    else{
                        if(j<=n || j>=m){
                            System.out.print("*");
                        }else{
                            System.out.print(" ");
                        }
                    }
                }
            System.out.println();
        }
    }
}
