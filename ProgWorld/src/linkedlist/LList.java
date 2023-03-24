package linkedlist;

public class LList {
    private Node head;
    private Node tail;
    private class Node{
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

    }
    void insertAtFirst(int value){
        Node n = new Node(value);
        n.next=head;
        head = n;
    }
    void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    void insertAtTail(int value){
        if(head==null){
            insertAtFirst(value);
            return;
        }
        Node n = new Node(value);
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = n;
    }
    void insertAtPos(int value,int position){
        if(position==1){
            insertAtFirst(value);
            return;
        }
        int count=1;
        Node temp = head;
        while(count+1!=position){
            temp=temp.next;
            count++;
        }
        Node n = new Node(value);
        n.next = temp.next;
        temp.next = n;
    }
    int deleteAtHead(){
        if(head==null){
            return -1;
        }
        int val = head.value;
        head = head.next;
        return val;
    }
    int deleteAtTail(){
        if(head==null){
            return -1;
        }
        if(head.next==null){
            return deleteAtHead();
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int val = temp.next.value;
        temp.next = null;
        return val;
    }
}
