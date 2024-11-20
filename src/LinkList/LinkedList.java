package LinkList;

import org.w3c.dom.NodeList;

public class LinkedList {

    //initializing Node
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Add Node At First
    public void addFirst(int data){
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        //if linked list is empty
        if( head == null ){
            head = tail =  newNode;
            return;
        }
        //if linked list is not empty
        //step2 - set new node = head
        newNode.next = head;   //link
        //step3 - set head at new node
        head = newNode;
    }

    //Add Node At Last
    public void addLast(int data){
        //step1 - create new node
        Node newNode = new Node(data);
        size++;
        //if linked list is empty
        if( head == null ){
            head = tail =  newNode;
            return;
        }
        //if linked list is not empty
        //step2 - set next of tail node = new node
        tail.next = newNode;   //link
        //step3 - set tail = new node
        tail = newNode;
    }

    //Add Node at Middle
    public void addMiddle(int index,int data){
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i<index-1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //Remove Node from First
    public int removeFirst(){
        if(size == 0){
            System.out.println("LinkedList is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    //Remove node from last
    public int removeLast(){
        if(size == 0){
            System.out.println("LinkedList is empty.");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = tail.data;
        Node temp = head;
        for(int i = 0; i < size-2; i++){
            temp = temp.next;
        }
        temp.next = null;
        temp = tail;
        size--;
        return val;
    }

    //Print Linked List
    public void printLL(){  //O(n)
        if(head == null){
            System.out.println("LinkedList is empty.");
            return;
        }
        Node tempNode = head;
        while (tempNode != null){
            System.out.print(tempNode.data+"->");
            tempNode = tempNode.next;
        }
        System.out.println("null");

    }

    //Search in a LinkedList (Iteratively)
    public int itrSearch(int key){
        Node temp = head;
        for(int i=0; i<size; i++){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    //Search key in LinkedList(Recursive)
    public int helper(Node head,int key){
        //Base case
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recSearch(int key){
        return helper(head,key);
    }


    //Reverse the LinkedList
    public void reverse(){  //O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    //Delete Nth node from end
    public void deleteNthFromEnd(int n){
        //calculate Size
        int sz = 0;
        Node temp = head;
        while (temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next;
            return;
        }

        int i = 1;
        int iToFind = sz - n;
        Node prev = head;
        while (i<iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node mergeLL(Node leftHead,Node rightHead){
        Node h1 = leftHead;
        Node h2 = rightHead;
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (h1 != null && h2 != null){
            if (h1.data <= h2.data){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }

        while (h1 != null){
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }

        while (h2 != null){
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if (head == null || head.next == null){
            return head;
        }

        //find mid
        Node mid = getMid(head);

        //MS on left and right LL
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return mergeLL(newLeft,newRight);
    }


    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.addMiddle(2,9);
        ll.printLL();
//        System.out.println("Size of the linked list : "+ll.size);
//        System.out.println("Value removed : "+ll.removeFirst());
//        ll.printLL();
//        System.out.println("Size of the linked list : "+ll.size);
//        System.out.println("Value removed : "+ll.removeLast());
//        ll.printLL();
//        System.out.println("Size of the linked list : "+ll.size);
//        System.out.println("iterative search : "+ll.itrSearch(4));
//        System.out.println("recursive search : "+ll.recSearch(9));
//        ll.reverse();
//        ll.deleteNthFromEnd(3);


    }
}
