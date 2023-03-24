package linkedlist;

public class DLList {
    public static void main(String[] args) {
        DoublyLList dll = new DoublyLList();
        dll.insertAtHead(1);
        dll.insertAtHead(2);
        dll.insertAtHead(2);
        dll.insertAtHead(1);
        dll.display();
//        dll.displayRev();

        DoublyLList dll2 = new DoublyLList();
        dll2.insertAtTail(1);
        dll2.insertAtTail(2);
        dll2.insertAtTail(3);
        dll2.insertAtTail(4);
        dll2.insertAtTail(3);
        dll2.insertAtTail(2);
        dll2.insertAtTail(1);
        dll2.display();
        //checking if ll is palindrome or not
        System.out.println(dll.palindromeCheck());
    }
}
