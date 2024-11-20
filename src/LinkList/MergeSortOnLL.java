package LinkList;

public class MergeSortOnLL extends LinkedList {
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
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.printLL();
        ll.head = ll.mergeSort(ll.head);
        ll.printLL();
    }
}
