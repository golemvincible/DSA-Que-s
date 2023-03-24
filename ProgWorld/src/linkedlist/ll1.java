package linkedlist;

public class ll1 {
    public static void main(String[] args) {
        LList ll = new LList();
        ll.insertAtFirst(1);
        ll.insertAtFirst(2);
        ll.insertAtFirst(3);
        ll.insertAtFirst(4);
        ll.display();

        LList ll2 = new LList();
        ll2.insertAtTail(15);
        ll2.insertAtTail(26);
        ll2.insertAtTail(38);
        ll2.insertAtTail(44);
        ll2.insertAtTail(55);
        ll2.insertAtTail(62);
        ll2.insertAtTail(37);
        ll2.display();

        //inserting value 23 at 5th position in ll2
        ll2.insertAtPos(69,5);
        ll2.insertAtPos(69,1);
        ll2.display();

        //deletion
        System.out.println(ll2.deleteAtHead());
        ll2.display();
        System.out.println(ll2.deleteAtTail());
        ll2.display();
    }
}
