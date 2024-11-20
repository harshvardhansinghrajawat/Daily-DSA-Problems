package Queue;

import java.util.Deque;
import java.util.LinkedList;

public class Deque_DoubleEndedQueue {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addLast(3);
        System.out.println(dq);
        System.out.println(dq.getFirst());
        dq.removeFirst();
        System.out.println(dq);
    }
}
