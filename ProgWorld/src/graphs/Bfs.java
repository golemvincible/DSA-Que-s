package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int n=7;
        ArrayList<ArrayList<Integer>> adj = graph(n);

        boolean[] vis = new boolean[n+1];
        ArrayList<Integer> bfs = bfsOfGraph(n,adj,vis);
        System.out.println(bfs);
    }

    private static ArrayList<Integer> bfsOfGraph(int n, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        ArrayList<Integer> bfs = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>();

                //queue mein node ko add kra aur visited mark kr diya
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    bfs.add(node);

                    for (Integer it : adj.get(node)) {
                        if (!vis[it]) {
                            vis[it] = true;
                            q.add(it);
                        }
                    }
                }
            }
        }
        return bfs;
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
