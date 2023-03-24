package trees.binarytrees;

import java.util.HashMap;

public class BinaryTreefromPreorderandInorderTraversal {
    private static Node buildingTree(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend, HashMap<Integer, Integer> index){
        /*preorder start 0 se horha h aur jaa rha h preorder.length tk aur hum har baar preorder ka
        index ++ kr rhe h i.e. prestart ko ++ kr rhe h to ek tym pr vo preorder.length tk chala jayega
        tb hume null return krna h aur humara tree ready ho jayega
         */
        if(prestart>preend)
            return null;

        int curr = preorder[prestart];
        Node node = new Node(curr);

        int pos = index.get(curr);
        int size = pos-instart;
        node.left=buildingTree(preorder,inorder,prestart+1,prestart+size,instart,pos-1,index);
        node.right=buildingTree(preorder,inorder,prestart+size+1,preend,pos+1,inend,index);

        return node;
    }
    public static Node buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i],i);
        }
        return buildingTree(preorder,inorder,0,preorder.length-1,0, inorder.length-1,index);
    }

    public static void main(String[] args) {
        int[] preorder={1,2,4,5,3,6,7};
        int[] inorder={4,2,5,1,6,3,7};
        Node root = buildTree(preorder,inorder);
        System.out.println(LevelOrderTraversal.levelOrder(root));
    }
}
