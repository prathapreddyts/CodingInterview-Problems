package linkedlist.fastslowpointers;

public class MiddleElement {
    public ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
