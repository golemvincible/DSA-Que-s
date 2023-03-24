package trees.binarytrees;
import java.util.*;
public class BinaryTreePaths {
    private static void helper(Node root,String path,List<String> res){
        if(root.left==null && root.right==null){
            path = path+root.val;
            res.add(path);
            return;
        }
        path = path+root.val+"->";
        if(root.left!=null){
            helper(root.left,path,res);
        }
        if(root.right!=null)
            helper(root.right,path,res);
    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> res = new ArrayList<>();
        if(root==null)
            return res;
        helper(root,"",res);
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        List<String> n = binaryTreePaths(root);
        System.out.println(n);

    }
}
