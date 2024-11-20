package LinkList;

public class ZigZagLL extends LinkedList {

    public static void zigzag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //alternative merging
        Node leftH = head;
        Node rightH = prev;
        Node nextL, nextR;
        while (leftH != null && rightH != null){
            nextL = leftH.next;
            leftH.next = rightH;
            nextR = rightH.next;
            rightH.next = nextL;

            rightH = nextR;
            leftH = nextL;
        }

    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);

        ll.printLL();
        zigzag();
        ll.printLL();
    }
}
