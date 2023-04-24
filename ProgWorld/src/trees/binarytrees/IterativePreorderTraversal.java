package src.trees.binarytrees;

import trees.binarytrees.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {
    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(1);
        root.left = new trees.binarytrees.Node(2);
        root.right = new trees.binarytrees.Node(3);
        root.left.left = new trees.binarytrees.Node(4);
        root.left.right = new trees.binarytrees.Node(5);
        root.right.left = new trees.binarytrees.Node(6);
        root.right.right = new trees.binarytrees.Node(7);
        System.out.println(preorderTrav(root));
    }

    private static List<Integer> preorderTrav(Node root) {
        List<Integer> res = new ArrayList<>();

        /*
            * we are storing rights because we are calling going left in a loop
            * once we have gone left we will not have access to right that's why
            * we need to store right in a stack so that we always get lates right
        */
        Stack<Node> rights = new Stack<>();
        Node node = root;
        while (node!=null){
            res.add(node.val);

            //it means that there exist a right for current node
            /*
                * we will store it in stack so that after calling loop further we will not loose access to it
                * when there is no left remaining we will check if we have any rights in our stack and we will go right if we have
                * we are using stack so that always the recent right will be stored at top
            */
            if(node.right!=null){
                rights.push(node.right);
            }

            //updating the node going further left
            node = node.left;

            //it means no more nodes at left so we will go right
            if(node==null && !rights.isEmpty()){
                node = rights.pop();
            }
        }

        return res;
    }
}
