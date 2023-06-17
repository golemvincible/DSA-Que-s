package src.trees.binarytrees.bst;
import trees.binarytrees.Node;

public class ValidateBinarySearchTree {
    private static boolean check(Node root,long minVal,long maxVal){
        if(root==null)
            return true;

        if(root.val<=minVal || root.val>=maxVal)
            return false;

        /*
         * all the elements on left of root must be smaller than root so for them maxVal = root.val
         * all the elements on right of root must be greater than root so for them minVal = root.val
         */
        return check(root.left,minVal,root.val) && check(root.right,root.val,maxVal);

    }
    public static boolean isValidBST(Node root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(10);
        root.left = new trees.binarytrees.Node(5);
        root.right = new trees.binarytrees.Node(15);
        root.left.left = new trees.binarytrees.Node(4);
        root.left.right = new trees.binarytrees.Node(7);
        root.left.right.right = new trees.binarytrees.Node(8);
        root.right.left = new trees.binarytrees.Node(12);
        root.right.right = new trees.binarytrees.Node(17);
        root.right.right.left = new trees.binarytrees.Node(16);
        System.out.println(isValidBST(root));
    }
}
