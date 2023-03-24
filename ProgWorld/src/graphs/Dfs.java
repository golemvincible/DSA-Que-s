package graphs;

import java.util.ArrayList;

public class Dfs {
    public static void main(String[] args) {
        int n=7;
        ArrayList<ArrayList<Integer>> adj = graph(n);

        boolean[] vis = new boolean[n+1];
        ArrayList<Integer> bfs = dfsOfGraph(n,adj);
        System.out.println(bfs);
    }

    private static ArrayList<Integer> dfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n+1];
        ArrayList<Integer> resDfs= new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if(!vis[i]){
                dfs(i,vis,adj,resDfs);
            }
        }
        return resDfs;
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> resDfs) {
        vis[node] = true;
        resDfs.add(node);

        for (Integer i : adj.get(node)) {
            if (!vis[i]) {
                dfs(i, vis, adj, resDfs);
            }
        }
    }

        private static ArrayList<ArrayList<Integer>> graph(int n) {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

            for(int i=0;i<=n;i++)
                adj.add(new ArrayList<Integer>());

            //1---2
            adj.get(1).add(2);
            adj.get(2).add(1);

            //2---3
            adj.get(2).add(3);
            adj.get(3).add(2);

            //2---7
            adj.get(2).add(7);
            adj.get(7).add(2);

            //3---5
            adj.get(3).add(5);
            adj.get(5).add(3);

            //5---7
            adj.get(5).add(7);
            adj.get(7).add(5);

            //4---6
            adj.get(4).add(6);
            adj.get(6).add(4);
            return adj;
        }
}
