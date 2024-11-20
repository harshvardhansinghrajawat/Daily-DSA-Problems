package Queue;

import java.util.Stack;

public class QueueUsing2Stacks {

    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        //IS EMPTY
        public static boolean isEmpty(){
            return s1.isEmpty();
        }

        //ADD  - O(n) or O(1)
        public static void add(int data){
            //ADD ->  O(1)

            //if s1 already has elements  S1 -> S2
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }

            //add new element in s1 (s1 is empty)
            s1.push(data);

            //transfer elements from s2 to s1 (S2 -> S1)
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }

            //ADD ->  O(1)
            //s1.push(data);
        }

        //REMOVE  - O(1) or O(n)
        public static int remove(){
            //PEMOVE -> O(1)
            if (s1.isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
            return s1.pop();

            //REMOVE -> O(n)

            //if (s1.isEmpty()){
            //    System.out.println("Queue is empty.");
            //    return -1;
            //}
            //while (!s1.isEmpty()){
            //    s2.push(s1.pop());
            //}
            //return s2.pop();
        }

        //PEEK  - O(1)
        public static int peek(){
            if (s1.isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }
            return s1.peek();
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
