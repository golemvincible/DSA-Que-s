package linkedlist;

public class DoublyLList {
    Node head,tail;
    private class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value=value;
        }
    }
    void insertAtHead(int value){
        Node n = new Node(value);
        n.next=head;
        n.prev = null;
        if(head!=null){
            head.prev=n;
        }
        head = n;
        if(head.next==null){
            tail=head;
        }
    }
    void insertAtTail(int value){
        if(head==null){
            insertAtHead(value);
            return;
        }
        Node n = new Node(value);
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        n.prev=temp;
        n.next=null;
        tail=n;
    }
    void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
        System.out.println("NULL");
    }
    void displayRev(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.prev;
        }
        System.out.println("NULL");
    }
    boolean palindromeCheck(){
        Node frw = head;
        Node bcw = tail;
        int size=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        if(size==1){
            return true;
        }
        int s=1,e=size-s+1;
        while (s<=e){
            if(frw.value!= bcw.value)
                return false;
            frw=frw.next;
            bcw=bcw.prev;
            s++;
        }
        return true;
    }
}
