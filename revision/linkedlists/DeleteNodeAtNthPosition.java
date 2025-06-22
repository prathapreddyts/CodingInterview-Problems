package revision.linkedlists;

public class DeleteNodeAtNthPosition {

    public ListNode deleteKthNode(ListNode head, int k) {
        return getDeleteNode(head, k);
    }

    public ListNode getDeleteNode(ListNode head, int k) {
        if (k <= 0) {
            return head;
        }
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return head.next;
        }

        ListNode current = head;
        ListNode prev = null;
        int index = 1;
        while (current != null && index < k) {
            prev = current;
            current = current.next;
            index++;
        }
        if (current == null) {
            return head;
        }
        prev.next = current.next;

        return head;
    }
}
