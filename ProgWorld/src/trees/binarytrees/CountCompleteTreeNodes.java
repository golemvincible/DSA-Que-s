package src.trees.binarytrees;
import trees.binarytrees.Node;

public class CountCompleteTreeNodes {
    private static int heightL(Node root){
        int height=0;
        while(root.left!=null){
            height++;
            root=root.left;
        }
        return height;
    }
    private static int heightR(Node root){
        int height=0;
        while(root.right!=null){
            height++;
            root=root.right;
        }
        return height;
    }
    private static int helper(Node root){
        if(root==null)  return 0;
        int lh = heightL(root);
        int rh = heightR(root);

        if(lh==rh)  return ((2<<(lh)) - 1);

        return helper(root.left) + helper(root.right) + 1;

    }
    public static int countNodes(Node root) {
        return helper(root);
    }
    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(5);
        root.left = new trees.binarytrees.Node(4);
        root.left.right = new trees.binarytrees.Node(2);
        root.left.right.left = new trees.binarytrees.Node(3);

        System.out.println(countNodes(root));
    }
}
