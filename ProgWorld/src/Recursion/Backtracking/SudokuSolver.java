package Recursion.Backtracking;

public class SudokuSolver {
    private static boolean isSafe(char[][] board,int n,int row,int col,char num){
        // 3 conditions should be satisfied

        //no. should not present in entire col i.e same col different row
        for(int i=0;i<n;i++){
            if(board[i][col]==num)
                return false;
        }
        //no. should not present in entire row i.e same row different col
        for(int i=0;i<n;i++){
            if(board[row][i]==num)
                return false;
        }
        //no. should not present in grid
        int x=row-row%3,y=col-col%3;
        for(int i=x;i<x+3;i++){
            for(int j=y;j<y+3;j++){
                if(board[i][j]==num)
                    return false;
            }
        }
        return true;
    }
    private static boolean solvingSudoku(char[][] boardd,int n){
        for (int row = 0; row < n; row++) {
            for(int col=0;col<n;col++){

                if(boardd[row][col]=='.'){
                    for(char i='1';i<='9';i++){
                        if(isSafe(boardd,n,row,col,i)){
                            boardd[row][col]=i;
                            if(solvingSudoku(boardd,n))
                                return true;
                            //if it is returning false we will backtrack
                            boardd[row][col]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        int n=board.length;
        solvingSudoku(board,n);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println("Before solving-:");
        for (char[] boardr :
                board) {
            for (Character it :
                    boardr) {
                System.out.print(it+"  ");
            }
            System.out.println();
        }
        solveSudoku(board);
        System.out.println("After solving-: ");
        for (char[] boardr :
                board) {
            for (Character it :
                    boardr) {
                System.out.print(it+"  ");
            }
            System.out.println();
        }
    }
}
