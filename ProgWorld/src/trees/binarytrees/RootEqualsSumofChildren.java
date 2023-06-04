package src.trees.binarytrees;
import trees.binarytrees.Node;

public class RootEqualsSumofChildren {
    private static boolean check(Node root){
        if(root==null)
            return true;

        if(root.left!=null && root.right!=null){
            if((root.left.val+root.right.val)==root.val)
                return check(root.left) && check(root.right);
            else
                return false;
        }
        else if(root.left==null && root.right==null)
            return true;
        return false;

    }
    public static boolean checkTree(Node root) {
        return check(root);
    }
    public static void main(String[] args) {

        trees.binarytrees.Node root = new trees.binarytrees.Node(3);
        root.left = new trees.binarytrees.Node(9);
        root.right = new trees.binarytrees.Node(20);
        root.right.left = new trees.binarytrees.Node(15);
        root.right.right = new trees.binarytrees.Node(7);

        System.out.println(checkTree(root));

    }
}
