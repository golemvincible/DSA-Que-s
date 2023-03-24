package trees.binarytrees;

public class BinaryTreeMaximumPathSum {
    int maxSum=Integer.MIN_VALUE;
    private int findingPath(Node root){
        if(root==null)
            return 0;

        int lefts = Math.max(0,findingPath(root.left));
        int rights = Math.max(0,findingPath(root.right));

        maxSum=Math.max(maxSum,root.val+lefts+rights);

        return root.val+Math.max(lefts,rights);
    }
    public int maxPathSum(Node root) {
        findingPath(root);
        return maxSum;
    }

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        int answer = obj.maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);

    }
}
