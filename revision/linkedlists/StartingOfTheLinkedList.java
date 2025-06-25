package revision.linkedlists;

import java.util.List;

public class StartingOfTheLinkedList {
    public ListNode findStartingPoint(ListNode head) {
        return findStartingPointHelper(head);
    }

    public ListNode findStartingPointHelper(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode newSlow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        while (newSlow != slow) {
            slow = slow.next;
            newSlow = newSlow.next;
        }
        return newSlow;
    }
}
