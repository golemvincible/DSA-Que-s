package graphs;
import java.util.*;
public class TopologicalSortBfs {
    static void bfs(int v, ArrayList<ArrayList<Integer>> adj,int[] indegree,Queue<Integer> q,int[] res,int k,boolean[] vis){

        while(!q.isEmpty()){
            int node=q.poll();
            res[k]=node;
            k++;
            for(Integer it:adj.get(node)){
                if(indegree[it]!=0){
                    indegree[it]=indegree[it]-1;
                }
                if(indegree[it]==0 && !vis[it]){
                    q.offer(it);
                    vis[it]=true;
                }
            }
        }
    }
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] vis = new boolean[v];
        int[] indegree = new int[v];
        Queue<Integer> q = new LinkedList<>();
        int k=0;
        for(int i=0;i<v;i++){
            for(Integer it:adj.get(i)){
                indegree[it] = indegree[it]+1;
            }
        }
        int[] res = new int[v];
        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.offer(i);
                vis[i]=true;
            }
        }
        for(int i=0;i<v;i++){
            if(!vis[i]){
                bfs(v,adj,indegree,q,res,k,vis);
            }
        }
        return res;
    }
}
