package graphs;
import java.util.*;
public class TopologicalSortDfs {
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> s){
        vis[node]=true;

        for(Integer it: adj.get(node)){
            if(!vis[it]){
                dfs(it,adj,vis,s);
            }
        }
        s.push(node);
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis= new boolean[v];
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i,adj,vis,s);
            }
        }

        int[] res = new int[v];

        for(int i=0;i<v;i++){
            res[i]=s.pop();
        }
        return res;
    }
}
