package graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int s) {
        int[] dist = new int[n];
        for(int i=0;i<n;i++)

            dist[i]=Integer.MAX_VALUE;
        dist[s]=0;
        for(int i=0;i<n-1;i++){
            for(ArrayList<Integer> it:edges){
                int u=it.get(0);
                int v=it.get(1);
                int dis=it.get(2);

                if(dist[u]+dis<dist[v] && dist[u]!=1e8){
                    dist[v]=dist[u]+dis;
                }
            }
        }

        //checking for -ve cycle by iterating 1 more time
        for(ArrayList<Integer> it:edges){
            int u=it.get(0);
            int v=it.get(1);
            int dis=it.get(2);
            if(dist[u]+dis<dist[v] && dist[u]!=1e8){
                int[] temp = new int[1];
                temp[0]=-1;
                return temp;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };



        int[] dist = BellmanFordAlgorithm.bellman_ford(V, edges, S);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
    }
}
