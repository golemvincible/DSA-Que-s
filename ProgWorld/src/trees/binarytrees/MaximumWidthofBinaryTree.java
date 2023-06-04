package src.trees.binarytrees;
import trees.binarytrees.Node;
import java.util.*;
class Pair{
    int ind;
    Node node;
    Pair(int ind,Node node){
        this.ind=ind;
        this.node=node;
    }
}
public class MaximumWidthofBinaryTree {
    public static int widthOfBinaryTree(Node root) {
        int maxWidth = 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0,root));

        while(!q.isEmpty()){
            int minInd = q.peek().ind;
            int size = q.size();

            int left=0,right=0;

            for(int i=0;i<size;i++){

                Pair p = q.poll();

                Node node = p.node;

                int curr_ind = p.ind-minInd;

                if(i==0)
                    left=curr_ind;
                else if(i==size-1)
                    right=curr_ind;

                if(node.left!=null)
                    q.offer(new Pair(curr_ind*2+1,node.left));

                if(node.right!=null)
                    q.offer(new Pair(curr_ind*2+2,node.right));

            }

            maxWidth=Math.max(maxWidth,left-right+1);

        }
        return maxWidth;
    }
    public static void main(String[] args) {

        trees.binarytrees.Node root = new trees.binarytrees.Node(3);
        root.left = new trees.binarytrees.Node(9);
        root.right = new trees.binarytrees.Node(20);
        root.right.left = new trees.binarytrees.Node(15);
        root.right.right = new trees.binarytrees.Node(7);

        System.out.println(widthOfBinaryTree(root));

    }
}
