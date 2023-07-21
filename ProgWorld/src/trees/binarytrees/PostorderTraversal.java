package src.trees.binarytrees;
import trees.binarytrees.Node;
import java.util.LinkedList;
import java.util.List;

public class PostorderTraversal {
    private static void postorderTrav(Node root, List<Integer> postorder){
        if(root==null)
            return;
        postorderTrav(root.left,postorder);
        postorderTrav(root.right,postorder);
        postorder.add(root.val);
    }
    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> postorder = new LinkedList<>();
        postorderTrav(root,postorder);
        return postorder;
    }


    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(1);
        root.left = new trees.binarytrees.Node(2);
        root.right = new trees.binarytrees.Node(3);
        root.left.left = new trees.binarytrees.Node(4);
        root.left.right = new trees.binarytrees.Node(5);
        root.right.left = new trees.binarytrees.Node(6);
        root.right.left.left = new trees.binarytrees.Node(7);
        root.right.left.left.left = new trees.binarytrees.Node(8);
        root.right.left.left.right = new trees.binarytrees.Node(9);
        System.out.println(postorderTraversal(root));
    }

}
