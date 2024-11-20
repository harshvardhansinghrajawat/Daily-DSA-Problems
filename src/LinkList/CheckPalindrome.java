package LinkList;

public class CheckPalindrome extends LinkedList {
    //Find Middle Node  (helper function for isPalindrome() function)
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // slow is Mid Node
    }

    public boolean isPalindrome(){
        if(head == null && head.next != null){
            return true;
        }
        // Find mid node
        Node mid = findMid(head);

        //Reverse 2nd half LL
        Node prev = null;
        Node curr = mid;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid = prev;

        //Check 1st half == 2nd half
        Node left = head;
        Node right = mid;
        while (right != null){
            if(left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }


    public static void main(String[] args) {
        CheckPalindrome ll = new CheckPalindrome();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        System.out.println(ll.isPalindrome());
    }
}
