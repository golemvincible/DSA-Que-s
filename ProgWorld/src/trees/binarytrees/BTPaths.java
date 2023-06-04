package src.trees.binarytrees;

import trees.binarytrees.Node;

import java.util.ArrayList;
import java.util.List;

public class BTPaths {
    private static void util(Node root,String route,List<String> path){
        if(root==null)
            return;
        if(root.right==null && root.left==null){
            route=route+String.valueOf(root.val);
            path.add(route);
            return;
        }

        //root
        route = route + String.valueOf(root.val) + "->";


        util(root.left,route,path);


        util(root.right,route,path);

    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> path = new ArrayList<>();

        util(root,"",path);

        return path;
    }
    public static void main(String[] args) {

        trees.binarytrees.Node root = new trees.binarytrees.Node(3);
        root.left = new trees.binarytrees.Node(9);
        root.right = new trees.binarytrees.Node(20);
        root.right.left = new trees.binarytrees.Node(15);
        root.right.right = new trees.binarytrees.Node(7);

        System.out.println(binaryTreePaths(root));

    }
}
