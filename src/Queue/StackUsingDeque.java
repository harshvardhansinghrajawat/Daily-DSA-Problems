package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class StackUsingDeque {
    static class Stack{
        static Deque<Integer> dq = new LinkedList<>();

        //IS EMPTY
        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //PUSH
        public static void push(int data){
            dq.addLast(data);
        }

        //POP
        public static int pop(){
            if(dq.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return dq.removeLast();
        }

        //PEEK
        public static int peek(){
            if(dq.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return dq.getLast();
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
