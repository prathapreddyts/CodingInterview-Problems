package revision.linkedlists;

public class DeleteNodeWithValue {
    public ListNode deleteNodeWithValueX(ListNode head, int value) {
        if (head == null) {
            return null;
        }
        if (head.val == value) {
            return head.next;
        }
        ListNode current = head;
        ListNode prev = null;
        while (current != null && current.val != value) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            prev.next = current.next;
        }

        return head;
    }
}
