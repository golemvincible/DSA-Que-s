package src.trees.binarytrees.bst;
import trees.binarytrees.Node;


import static trees.binarytrees.LevelOrderTraversal.levelOrder;

public class BSTfromPreOrder {
    static int ind=0;
    private static Node helper(int[] p,int maxVal){
        if(ind==p.length || p[ind]>maxVal)
            return null;

        Node root = new Node(p[ind]);
        ind++;

        root.left = helper(p,root.val);

        root.right = helper(p,maxVal);

        return root;

    }
    public static Node bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MAX_VALUE);
    }
    public static void main(String[] args) {

        Node root = bstFromPreorder(new int[]{8,5,1,7,10,12});
        System.out.println(levelOrder(root));
    }
}
