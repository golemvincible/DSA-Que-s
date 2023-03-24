package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GraphArrayList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int n=6,m;
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<Integer>());

        //1---2
        adj.get(1).add(2);
        adj.get(2).add(1);

        //2---3
        adj.get(2).add(3);
        adj.get(3).add(2);

        //2---4
        adj.get(2).add(4);
        adj.get(4).add(2);

        //3---4
        adj.get(3).add(4);
        adj.get(4).add(3);

        //5---3
        adj.get(5).add(3);
        adj.get(3).add(5);

        //1---3
        adj.get(1).add(3);
        adj.get(3).add(1);

        //1---5
        adj.get(1).add(5);
        adj.get(5).add(1);
    }
}
 