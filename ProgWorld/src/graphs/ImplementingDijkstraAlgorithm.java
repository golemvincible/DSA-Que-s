package graphs;
import java.util.*;
import java.lang.*;
import java.io.*;

public class ImplementingDijkstraAlgorithm {

    public static void main(String[] args) throws IOException {
        int V = 3, E=3,S=2;
        ArrayList<Integer> node1 = new ArrayList<Integer>()  {{add(1);add(1);}};
        ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
        ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
        ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
        ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
        ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};

        ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node1);
                add(node2);
            }
        };
        ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node3);
                add(node4);
            }
        };
        ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
            {
                add(node5);
                add(node6);
            }
        };
        ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
            {
                add(inter1); // for 1st node
                add(inter2); // for 2nd node
                add(inter3); // for 3rd node
            }
        };
        //add final values of adj here.
        Solution obj = new Solution();
        int[] res= obj.dijkstra(V,adj,S);

        for(int i=0;i<V;i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();

    }
}
class Node{
    int dis,node;
    Node(int dis,int node){
        this.dis=dis;
        this.node=node;
    }
}
class Solution {
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s)
    {
        Queue<Node> q = new LinkedList<>();
        int[] dis = new int[v];
        Set<Node> st=new HashSet<>();

        for(int i=0;i<v;i++){
            dis[i]=Integer.MAX_VALUE;
        }
        dis[s]=0;

        q.offer(new Node(0,s));

        while(!q.isEmpty()){

            int nnode=q.peek().node;
            int dist=q.peek().dis;
            q.remove();
            int initdistance=dis[nnode];
            for(ArrayList<Integer> it:adj.get(nnode)){
                int n = it.get(0);
                int d = it.get(1);
                if(initdistance+d<dis[n]){
                    dis[n]=initdistance+d;
                    q.offer(new Node(dis[n],n));
                }
            }

        }
        return dis;
    }
}
