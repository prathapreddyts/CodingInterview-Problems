package revision.linkedlists;

public class InsertAtHead {
    public ListNode insertAtHead(ListNode head, int val) {
        if (head == null) {
            return new ListNode(val);
        }
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        return head;

    }
}
