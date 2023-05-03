package src.trees.binarytrees;
import trees.binarytrees.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrderTrav1Stack {
    public static void main(String[] args) {
        trees.binarytrees.Node root = new trees.binarytrees.Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(postorderTraversal(root));
    }

    private static List postorderTraversal(Node root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }
}
