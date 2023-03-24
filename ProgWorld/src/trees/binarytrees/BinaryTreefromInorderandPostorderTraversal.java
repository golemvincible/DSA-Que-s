package trees.binarytrees;

import java.util.HashMap;

public class BinaryTreefromInorderandPostorderTraversal {
    private static Node buildingTree(int[] inorder, int[] postorder,int instart,int inend,int poststart,int postend,HashMap<Integer,Integer> index){
        if(poststart<0 || instart>inend)
            return null;
        int curr = postorder[poststart];
        Node node = new Node(curr);
        int pos = index.get(curr);
        int size=inend-pos;

        node.right= buildingTree(inorder,postorder,pos+1,inend,poststart-1,poststart-size,index);
        node.left= buildingTree(inorder,postorder,instart,pos-1,poststart-size-1,postend,index);

        return node;
    }
    public static Node buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i],i);
        }
        return buildingTree(inorder,postorder,0,inorder.length-1, postorder.length-1,0,index);
    }

    public static void main(String[] args) {
        int[] postorder={4,5,2,6,8,3,1};
        int[] inorder={4,2,5,1,6,3,8};
        Node root = buildTree(inorder,postorder);
        System.out.println(LevelOrderTraversal.levelOrder(root));
    }
}
