package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class ReverseLinkedList {
    public static ListNode reverse(ListNode head) {
        ListNode prev=null;
        ListNode current=head;
        while(current!=null){
            ListNode nexNode = current.next;
            current.next=prev;
            prev=current;
            current=nexNode;
        }
        head=prev;
        return head;
    }
}
