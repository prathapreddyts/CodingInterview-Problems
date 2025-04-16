package linkedlist.fastslowpointers;

public class RemoveNthNodeFromEnd {
    public static linkedlist.fastslowpointers.ListNode removeNthLastNode(linkedlist.fastslowpointers.ListNode head, int n) {
        linkedlist.fastslowpointers.ListNode dummy = new linkedlist.fastslowpointers.ListNode(0);
        dummy.next = head;
        linkedlist.fastslowpointers.ListNode fast = dummy;
        linkedlist.fastslowpointers.ListNode slow = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}


