package revision.linkedlists;


public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode revHead = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = revHead;
            revHead = current;
            current = nextNode;
        }
        return revHead;
    }
}
