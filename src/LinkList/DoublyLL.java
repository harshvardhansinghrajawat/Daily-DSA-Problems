package LinkList;

import ArrayList.SortingAnArrayList;

public class DoublyLL {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add node at first
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //add node at last
    public static void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        tail = newNode;
    }

    //delete node from first
    public static int removeFirst(){
        if(head == null){
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    //delete node from last
    public static int removeLast(){
        if(head == null){
            System.out.println("DLL is empty.");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    //reverse the DLL
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //print doubly LL
    public void printDLL(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);

        dll.printDLL();
        System.out.println(dll.size);

//        dll.removeFirst();
//        dll.printDLL();
//        System.out.println(dll.size);
//
//        dll.removeLast();
//        dll.printDLL();
//        System.out.println(dll.size);

        dll.reverse();
        dll.printDLL();
    }
}
