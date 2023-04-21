package trees.binarytrees;
import trees.binarytrees.Node;
public class SameTree {
    public static boolean isSameTree(Node p, Node q) {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        // agar dono trees ke node ki value same h to hum age check krenge
        if(p.val==q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        //hum iss condition pr aa gye h mtlb dono trees ki value same nhi h isliye hum false return kr denge
        return false;
    }

    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.right.left = new Node(4);
        root1.right.right = new Node(5);

        trees.binarytrees.Node root2 = new trees.binarytrees.Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.right.left = new Node(4);

        if (isSameTree(root1, root2))
            System.out.println("Two Trees are identical");
        else System.out.println("Two trees are non-identical");
    }
}
