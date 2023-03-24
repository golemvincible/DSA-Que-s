package trees.binarytrees;
import java.util.*;

public class BottomViewBT {
    public static ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair> q = new LinkedList<>();

        TreeMap<Integer,Integer> m = new TreeMap<>();

        q.offer(new Pair(root,0));

        while(!q.isEmpty()){
            Node node = q.peek().node;
            int x = q.peek().x;
            q.remove();

            // x-> vertical

            m.put(x,node.val);


            if(node.left!=null){
                q.offer(new Pair(node.left,x-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,x+1));
            }
        }

        ArrayList<Integer> bottomview = new ArrayList<>();
        for(Integer it:m.values()){
            bottomview.add(it);
        }
        return bottomview;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(bottomView(root));
    }
}
