package trees.binarytrees;

import java.util.LinkedList;
import java.util.List;

public class PreorderTraversal {
    private static void preorderTrav(List<Integer> preorder, trees.binarytrees.Node root){
        if(root==null)
            return;
        preorder.add(root.val);
        preorderTrav(preorder,root.left);
        preorderTrav(preorder,root.right);
    }
    public static List<Integer> preorderTraversal(trees.binarytrees.Node root) {
        List<Integer> preorder = new LinkedList<>();
        preorderTrav(preorder,root);
        return preorder;
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
        System.out.println(preorderTraversal(root));
    }
}
