package Recursion.Pattern;

public class PatternKrish3 {
    public static void main(String[] args) {
        int r=5;
        int col=2*r-1;
        int left = col/2;
        int right = col-1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < col; j++) {
                if(i==r-1 || i==0){
                    if(j>=left && j<=right){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
                else{
                    if(j==left || j==right){
                        System.out.print("*");
                    }else{
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
            left--;
            right--;
        }
    }
}
