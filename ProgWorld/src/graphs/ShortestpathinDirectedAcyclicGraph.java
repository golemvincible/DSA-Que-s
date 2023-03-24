package graphs;

import java.util.*;
class Pair{
    int v;
    int weight;
    Pair(int v,int weight){
        this.v=v;
        this.weight=weight;
    }
    int getWeight(){
        return weight;
    }
    int getDest(){
        return v;
    }
}
class ShortestpathinDirectedAcyclicGraph {
    private void dfs(int[][] edges, boolean[] vis, Stack<Integer> s, int node, ArrayList<ArrayList<Pair>> adj){
        vis[node]=true;

        for(Pair it:adj.get(node)){
            int nnode=it.getDest();
            if(!vis[nnode]){
                dfs(edges,vis,s,nnode,adj);
            }
        }

        s.push(node);
    }
    public int[] shortestPath(int n,int m, int[][] edges) {
        //making the graph
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }

        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
        }

        //topo sort
        boolean[] vis=new boolean[n];
        Stack<Integer> s = new Stack<>();
        int[] dis=new int[n];
        for(int i=1;i<n;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(edges,vis,s,i,adj);
                while(!s.isEmpty()){
                    int node=s.pop();
                    int initdis=dis[node];
                    if(initdis==Integer.MAX_VALUE){
                        dis[node]=-1;
                        break;
                    }
                    for(Pair it:adj.get(node)){
                        int dest=it.getDest();
                        int newdis=it.getWeight();

                        if(newdis+initdis < dis[dest]){
                            dis[dest]=initdis+newdis;
                        }
                    }

                }
            }
        }

        return dis;

    }
}