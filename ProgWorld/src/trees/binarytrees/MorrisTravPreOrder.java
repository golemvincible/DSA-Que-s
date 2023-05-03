package src.trees.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTravPreOrder {
    private static List<Integer> preorderTraversal(trees.binarytrees.Node root){
        List<Integer> preorder = new ArrayList<>();

        trees.binarytrees.Node curr = root;

        while(curr!=null){
            if(curr.left==null){
                preorder.add(curr.val);
                curr=curr.right;
            }
            else {
                trees.binarytrees.Node prv = curr.left;
                while (prv.right!=null && prv.right!=curr){
                    prv=prv.right;
                }
                if (prv.right==null){
                    //made the link
                    prv.right=curr;

                    preorder.add(curr.val);

                    //moving forward
                    curr=curr.left;
                }
                //already linked to curr so we need to de link
                else {
                    prv.right=null;
                    curr=curr.right;
                }
            }
        }

        return preorder;
    }
    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(1);
        root.left = new trees.binarytrees.Node(2);
        root.right = new trees.binarytrees.Node(3);
        root.left.left = new trees.binarytrees.Node(4);
        root.left.right = new trees.binarytrees.Node(5);
        root.left.right.right = new trees.binarytrees.Node(6);
        System.out.println(preorderTraversal(root));
    }
}
