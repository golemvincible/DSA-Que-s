package trees.binarytrees;
import java.util.*;
public class LowestCommonAncestor {
    private static Node util(Node root, Node p, Node q){
        if(root==null || root==p || root==q)
            return root;
        Node left = util(root.left,p,q);
        Node right = util(root.right,p,q);
        if(left!=null && right!=null)
            return root;
        else if(left!=null)
            return left;
        return right;
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root==null)
            return null;
        return util(root,p,q);
    }

    public static void main(String[] args) {

        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        Node n = lowestCommonAncestor(root,root.left,root.right.right);
        System.out.println(n.val);

    }
}
