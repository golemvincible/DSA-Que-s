package src.trees.binarytrees;

public class SumReplacementBT {
    static int max=0;
    private static void sumReplace(trees.binarytrees.Node root){
        if(root==null)
            return;
        sumReplace(root.left);
        sumReplace(root.right);

        if(root.left!=null)
            root.val+=root.left.val;
        if(root.right!=null)
            root.val+=root.right.val;

    }
    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(1);
        root.left = new trees.binarytrees.Node(2);
        root.right = new trees.binarytrees.Node(3);
        root.left.left = new trees.binarytrees.Node(4);
        root.left.right = new trees.binarytrees.Node(5);
        root.right.left = new trees.binarytrees.Node(6);
        root.right.right = new trees.binarytrees.Node(7);

        sumReplace(root);
        System.out.println(trees.binarytrees.LevelOrderTraversal.levelOrder(root));
    }
}
