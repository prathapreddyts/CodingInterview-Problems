package revision.linkedlists;


public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }

    public ListNode removeNthNodeFromEnd(ListNode head, int position) {
        int lenghtOfLL = getLenghtOfLL(head);
        if (lenghtOfLL == position) {
            return head.next;
        }
        ListNode current = head;
        if (lenghtOfLL < position) {

            for (int i = 0; i < lenghtOfLL - position; i++) {
                current = current.next;
            }
        }
        current.next = current.next.next;
        return head;

    }

    public int getLenghtOfLL(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count += 1;
            current = current.next;
        }
        return count;
    }

}
