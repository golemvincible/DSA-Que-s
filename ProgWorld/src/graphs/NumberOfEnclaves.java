package graphs;

public class NumberOfEnclaves {
    private static void dfs(int[][] grid,boolean[][] vis,int i,int j,int[][] dirs){
        int m=grid.length;
        int n= grid[0].length;

        vis[i][j]=true;
        grid[i][j]=0;

        for(int[] dir:dirs){
            int x=i+dir[0];
            int y=j+dir[1];

            if(x<0 || y<0 || x>=m || y>=n || vis[x][y] || grid[x][y]==0)    continue;

            dfs(grid,vis,x,y,dirs);
        }
    }
    public static int numEnclaves(int[][] grid) {

        int m=grid.length,n=grid[0].length;
        if(m<=1 || n<=1)    return 0;
        int count=0;
        boolean[][] vis = new boolean[m][n];
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<n;i++){
            if(!vis[0][i] && grid[0][i]==1)
                dfs(grid,vis,0,i,dirs);
            if(!vis[m-1][i] && grid[m-1][i]==1)
                dfs(grid,vis,m-1,i,dirs);

        }
        for(int i=0;i<m;i++){
            if(!vis[i][0] && grid[i][0]==1)
                dfs(grid,vis,i,0,dirs);
            if(!vis[i][n-1] && grid[i][n-1]==1)
                dfs(grid,vis,i,n-1,dirs);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&& grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1,0,0,0,0,1,1,0,0,0},{1,0,1,1,1,0,1,0,1,1,1,0},{1,1,0,1,0,0,1,1,0,1,1,1},{1,0,0,1,1,0,1,0,1,0,1,0},{1,0,0,0,0,1,0,0,1,1,0,1},{1,1,1,0,0,0,1,0,0,1,1,1},{1,1,1,0,0,0,0,1,0,1,0,1},{0,1,1,1,1,0,0,1,1,0,0,0},{0,1,0,1,0,1,0,1,0,0,0,1},{0,0,1,0,1,1,0,0,0,1,1,1}};
        int res = numEnclaves(grid);
        System.out.println(res);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
//        for (int[] g :
//                grid) {
//            for (Integer i :
//                    g) {
//                System.out.print(g[i]);
//            }
//            System.out.println();
//        }
    }
}
