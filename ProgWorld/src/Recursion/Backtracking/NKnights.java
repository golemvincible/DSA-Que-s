package Recursion.Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int n=4;
        int row = 0;
        boolean board[][] = new boolean[n][n];

        //we are not passing column because we have to start from 0 at every row
        int res = nKnights(board,row);
        System.out.println(res);

    }

    private static int nKnights(boolean[][] board, int row) {
        /*if row == board.length then we know we have placed queen on last row
          also that means now we got 1 ans that's why we are returning 1 and displaying
          the board
         */
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }

        /*for every call we are initializing count from 0 if we reach base condition
          1 will be returned then at the time of exit of the function we will add
          this 1 to the previous count and return count in the end
         */
        int count = 0;

        //placing queen and checking for every row and column
        for(int col=0;col< board.length;col++){
            //checking if the position is safe or not
            if(isSafe(board,row,col)){
                //placing queen
                board[row][col] = true;
                //placed queen and going to next row
                count = count + nKnights(board,row+1);
                //end of the function so reverting all the chnges we made
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        //vertical up

        int r,right,left;
        int c,up;
        r = row-2;
        right = col+1;
        left = col-1;

        //up left
        if(r>=0 && left>=0){
            if(board[r][left]){
                return false;
            }
        }
        //up right
        if(r>=0 && right< board.length){
            if(board[r][right]){
                return false;
            }
        }

        //right

        c = col+2;
        up = row-1;

        //right up
        if(up>=0 && c< board.length){
            if(board[up][c]){
                return false;
            }
        }

        //left
        c = col-2;
        up = row-1;

        //left up
        if(up>=0 && c>=0){
            if(board[up][c]){
                return false;
            }
        }

        return true;
    }
    private static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]){
                    System.out.print("K ");
                }else{
                    System.out.print("N ");
                }
            }
            System.out.println();
        }
    }
}
