package graphs;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSCycleDetectionUndirectedGraph {
    public static void main(String[] args) {
        int n=5;
//        ArrayList<ArrayList<Integer>> adj = graph2(7);
        ArrayList<ArrayList<Integer>> adj = graph1(5);

        if(isCycle(n,adj))
            System.out.println("Cycle is present");
        else
            System.out.println("No cycle");

    }

    private static boolean isCycle(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if(!vis[i]){
                if (checkForCycle(adj,i,vis,-1))
                    return true;
            }
        }
        return false;
    }

    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, int prv) {
        vis[node] = true;
        for (Integer i :
                adj.get(node)) {
            if (!vis[i]) {
                checkForCycle(adj, i, vis, node);
            } else if (vis[i] && i != prv) {
                return true;
            }
        }
        return false;
    }

    private static ArrayList<ArrayList<Integer>> graph1(int n) {

        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(i, new ArrayList<Integer>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);
        return adj;
    }
    private static ArrayList<ArrayList<Integer>> graph2(int n) {
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
        adj.get(5).add(4);
        adj.get(4).add(5);

        //4---6
        adj.get(4).add(6);
        adj.get(6).add(4);
        return adj;
    }
}
