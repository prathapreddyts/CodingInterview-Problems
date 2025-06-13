package blind75;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastNode = head;
        ListNode slowNode = head;

        for (int i = 0; i < n; i++) {
            if (fastNode == null) {
                return head;
            }
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return head.next;
        }

        while (fastNode.next != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;

        return head;
    }
}
