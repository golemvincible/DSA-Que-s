package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{
    int u,v,dis;
    Edge(int u,int v,int dis){
        this.u=u;
        this.v=v;
        this.dis=dis;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.dis-compareEdge.dis;
    }
}
public class KruskalAlgorithm {
    static int spanningTree(int V, int e, int edges[][]){


        List<Edge> edge = new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int dis = edges[i][2];
            Edge temp = new Edge(u,v,dis);
            edge.add(temp);
        }
        Collections.sort(edge);
        DisjointSet ds = new DisjointSet(V);
        int mstwt=0;

        for (int i = 0; i < edge.size(); i++) {
            int dis = edge.get(i).dis;
            int u = edge.get(i).u;
            int v = edge.get(i).v;
            //if u and v's ultimate parent are diffrent that means they belong to different componenets
            if(ds.findUPar(u)!=ds.findUPar(v)){
                mstwt+=dis;
                ds.unionBySize(u,v);
            }
        }
        return mstwt;
    }
}
