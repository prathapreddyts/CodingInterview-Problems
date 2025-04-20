package linkedlist.fastslowpointers;

public class RemoveCycle {
    public static ListNode removeCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return head;
        }
        //Logic to find the starting point of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        //traverse to last but node and point to null
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }
}
