package revision.linkedlists;

public class DeleteTailNode {

    public ListNode deleteTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode current = head;
        ListNode prev = null;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return head;
    }

}
