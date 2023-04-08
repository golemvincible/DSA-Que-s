package src.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestCycleinaGraph {
    private static int ans=Integer.MAX_VALUE;
    private static void bfs(int src,int n,ArrayList<ArrayList<Integer>> adj){
        // int ans=Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();

        int[] parent = new int[n];
        int[] dis = new int[n];
        for(int i=0;i<n;i++){
            dis[i]=-1;
            parent[i]=-1;
        }

        dis[src]=0;
        parent[src]=src;
        q.offer(src);

        while(!q.isEmpty()){
            int node = q.poll();

            for(Integer it:adj.get(node)){
                if(parent[it]==-1){
                    dis[it]=dis[node]+1;
                    parent[it]=node;
                    q.offer(it);
                }
                //visited
                else if(parent[node]!=it && parent[it]!=-1){
                    /*
                        parent[it]!=node means it is our next node but we didn't reach is from current node that means
                        we have reached it from somewhere else
                        which means there is a cycle
                    */
                    ans=Math.min(ans,(dis[it]+dis[node]+1));
                }
            }
        }
        // return ans;
    }
    public static int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it:edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        for(int i=0;i<n;i++){
            if(adj.get(i)!=null){
                bfs(i,n,adj);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    public static void main(String[] args) {
            int[][] edges = {{0,1},{1,2},{2,0},{3,4},{4,5},{5,6},{6,3}};
            System.out.println(findShortestCycle(37,edges));
    }
}
