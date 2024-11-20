package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueUsingDeque {
    static class Queue{
        static Deque<Integer> dq = new LinkedList<>();

        //IS EMPTY
        public static boolean isEmpty(){
            return dq.isEmpty();
        }

        //ADD
        public static void add(int data){
            dq.addLast(data);
        }

        //REMOVE
        public static int remove(){
            if(dq.isEmpty()){
                System.out.println("Queue is Empty.");
                return -1;
            }

            return dq.removeFirst();
        }

        //PEEK
        public static int peek(){
            if(dq.isEmpty()){
                System.out.println("Queue is Empty.");
                return -1;
            }

            return dq.getFirst();
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
