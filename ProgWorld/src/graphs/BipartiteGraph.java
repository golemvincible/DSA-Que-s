package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private static boolean dfs(ArrayList<ArrayList<Integer>>adj,int i,int[] color,int pcolor){


        for(Integer it:adj.get(i)){
            if(color[it]==-1){
                color[it]=1-pcolor;
                if(!dfs(adj,it,color,color[it]))    return false;
            }else if(color[it]==pcolor)
                return false;
        }
        return true;
    }
    private static boolean bfs(ArrayList<ArrayList<Integer>>adj, int v, int i, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        color[i]=0;

        while(!q.isEmpty()){
            int node=q.poll();

            for(Integer it: adj.get(node)){
                if(color[it] == -1){
                    color[it]=1-color[node]; //opposite color of previous node
                    q.add(it);
                }else if(color[it] == color[node]){ //if the color of current node is equal to previos node or next node
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[v];

        for(int i=0;i<v;i++)    color[i]=-1;

        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(bfs(adj,v,i,color)==false) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

    }
}
