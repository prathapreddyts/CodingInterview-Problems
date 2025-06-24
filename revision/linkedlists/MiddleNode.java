package revision.linkedlists;

import java.util.List;

public class MiddleNode {
    public ListNode middleOfLinkedList(ListNode head) {
        return middleOfLinkedListHelper(head);

    }

    public ListNode middleOfLinkedListHelper(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
