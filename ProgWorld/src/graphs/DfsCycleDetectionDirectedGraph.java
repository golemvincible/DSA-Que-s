package graphs;
import java.util.*;
public class DfsCycleDetectionDirectedGraph {
    private static boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathVis,int i){
        vis[i]=true;
        pathVis[i]=true;

        for(Integer it:adj.get(i)){
            if(!vis[it]){
                if(dfs(adj,vis,pathVis,it)) return true;
            }else if(vis[it] && pathVis[it])   return true;
        }
        pathVis[i]=false;
        return false;
    }
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis= new boolean[v];
        boolean[] pathVis = new boolean[v];

        for(int i=0;i<v;i++){
            if(!vis[i]){
                if(dfs(adj,vis,pathVis,i))   return true;
            }
        }
        return false;
    }
}
