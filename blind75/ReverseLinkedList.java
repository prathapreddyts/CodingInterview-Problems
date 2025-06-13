package blind75;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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
