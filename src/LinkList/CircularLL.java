package LinkList;

public class CircularLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static Node last;
    public static int size;

    //add first
    public static void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if (last == null){
            last = newNode;
            newNode.next = last.next;
            return;
        }
        newNode.next = last.next;
        last.next = newNode;
    }

    //print circularll


    public static void main(String[] args) {

    }
}
