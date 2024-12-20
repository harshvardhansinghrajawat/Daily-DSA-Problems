package Queue;

public class CircularQueueUsingArray {
    static class CircularQueue{
        static int arr[];
        static int size;
        static int rear;
        static int front;
        CircularQueue(int n){
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        //IS EMPTY
        public static boolean isEmpty(){
            return rear == -1 && front == -1;
        }

        //IS FULL
        public static boolean isFull(){
            return (rear+1) % size == front;
        }

        //ADD
        public static void add(int data){
            if (isFull()){
                System.out.println("Queue is full.");
                return;
            }
            if (front == -1){
                front = 0;
            }

            rear = (rear+1) % size;
            arr[rear] = data;
        }

        //REMOVE
        public static int remove(){
            if (isEmpty()){
                System.out.println("Queue is empty.");
                return -1;
            }

            int x = arr[front];

            if (rear == front){//DELETE LAST ELEMENT
                rear = front = -1;
            }else {
                front = (front+1) % size;
            }
            return x;
        }

        //PEEK
        public static int peek(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}
