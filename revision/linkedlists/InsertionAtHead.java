package revision.linkedlists;

public class InsertionAtHead {
    public ListNode insertAtTail(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }
        ListNode current = head;
        ListNode lastNode = getLastNode(current);
        ListNode newNode = new ListNode(val);
        if (lastNode != null) {
            lastNode.next = newNode;
        }
        return head;
    }

    public ListNode getLastNode(ListNode current) {
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
}
