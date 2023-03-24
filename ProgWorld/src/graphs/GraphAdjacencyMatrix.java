package graphs;

public class GraphAdjacencyMatrix {
    public static void main(String[] args) {
        int n=5,m;
        int[][] adj = new int[n+1][n+1];

        //1---2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //2---3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //2---4
        adj[2][4] = 1;
        adj[4][2] = 1;

        //3---4
        adj[3][4] = 1;
        adj[4][3] = 1;

        //5---3
        adj[5][3] = 1;
        adj[3][5] = 1;

        //1---3
        adj[1][3] = 1;
        adj[3][1] = 1;

        //1---5
        adj[1][5] = 1;
        adj[5][1] = 1;

        for(int i[]:adj){
            for(int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
