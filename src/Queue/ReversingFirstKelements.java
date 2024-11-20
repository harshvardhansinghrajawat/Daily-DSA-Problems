package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingFirstKelements {
    public static void reverseFirstKelements(Queue<Integer> q,int k){
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<k; i++){
            s.push(q.remove());
        }
        while (!s.isEmpty()){
            q.add(s.pop());
        }
        for (int i=0; i<k; i++){
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        reverseFirstKelements(q,5);

        while (!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
    }
}
