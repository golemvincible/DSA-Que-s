package Recursion.Pattern;

public class PatternShubh1 {
    public static void main(String[] args) {
        patt(5);
    }

    private static void patt(int r) {
        int row=r;
        int col=2*r;
        for (int i = 1; i <= row; i++) {
            int k=col/2;
            for (int j = 1; j <= col; j++) {
                if(i>1){
                    if(j<(col/2-r+1)){
                        System.out.print(j);
                    }else if(j<=(col/2+r-1)){
                        System.out.print("*");
                    }else {
                        System.out.print(col-j);
                    }

                }else {
                    if (j <= r) {
                        System.out.print(j);
                    } else {
                        System.out.print(k);
                        k--;
                    }
                }
            }
            System.out.println();
        }
    }
}
