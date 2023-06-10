package src.trees.binarytrees;
import trees.binarytrees.Node;

public class FlattenBinaryTreetoLinkedList {
    static Node prev = null;

    private static void flat(Node root){
        if(root==null){
            return;
        }

        flat(root.right);
        flat(root.left);

        root.right = prev;
        root.left=null;

        prev=root;
    }

    public static void flatten(Node root) {
        flat(root);
    }
}
