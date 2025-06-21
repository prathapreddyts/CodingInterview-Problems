package revision.linkedlists;

public class DeleteHeadNode {
    public ListNode deleteHead(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return null;
        }
        return head.next;
    }
}
