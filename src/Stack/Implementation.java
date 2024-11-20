package Stack;

import java.util.*;


public class Implementation {

    //USING ARRAYLIST
    /*
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        //TO CHECK STACK IS EMPTY
        public static boolean isEmpty(){
            return list.size() == 0;
        }

        //PUSH
        public static void push(int data){
            list.add(data);
        }

        //POP
        public static int pop(){
            if(isEmpty()) return -1;
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        //PEEK
        public static int peek(){
            if (isEmpty()) return -1;
            return list.get(list.size()-1);
        }
    }
    */

    //USING LINKEDLIST
    /*
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    static class Stack{
        static Node head = null;

        //IS EMPTY
        public static boolean isEmpty(){
            return head == null;
        }

        //PUSH
        public static void push(int data){
            Node newNode = new Node(data);
            if (isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //POP
        public static int pop(){
            if (isEmpty()) return -1;
            int top = head.data;
            head = head.next;
            return top;
        }

        //PEEK
        public static int peek(){
            if (isEmpty()) return -1;
            return head.data;
        }

    }
    */

    public static void main(String[] args) {
//        Stack s = new Stack();
        Stack<Integer> s = new Stack<>(); // Implementation using collection frameworks
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

    }
}
