package LinkList;

public class RemovingCycleInLL extends LinkedList {
    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                cycle = true;
                break;
            }
        }
        if(cycle == false) return;

        //find meeting point
        slow = head;
        Node prev = null;
        while (slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle
        prev.next = null;
    }
    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next;
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}
