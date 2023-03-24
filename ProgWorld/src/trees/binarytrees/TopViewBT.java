package trees.binarytrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBT {
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Queue<Pair> q = new LinkedList<>();

        TreeMap<Integer,Integer> m = new TreeMap<>();

        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            Node node = q.peek().node;
            int x = q.peek().x;
            q.remove();

            // x-> vertical

            if(!m.containsKey(x)){
                m.put(x,node.val);
            }

            if(node.left!=null){
                q.offer(new Pair(node.left,x-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,x+1));
            }
        }

        ArrayList<Integer> topview = new ArrayList<>(m.values());
        return topview;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(topView(root));
    }
}
