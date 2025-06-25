package revision.linkedlists;

public class FindIntersectionPoint {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        combineOneListNodeWithTail(headA, headB);
        ListNode intersection = getStartingPoint(headA);
        removecombinedListNodeWithTailNode(headA);

        return intersection;
    }


    public ListNode getStartingPoint(ListNode headA) {
        ListNode slow = headA, fast = headA;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = headA;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }

    ListNode tailConnector = null;
    public void combineOneListNodeWithTail(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return;
        }
        ListNode current = headA;
        while (current.next != null) {
            current = current.next;
        }
        tailConnector = current;
        current.next = headB;
    }
    public void removecombinedListNodeWithTailNode(ListNode headA) {
        if (tailConnector != null) {
            tailConnector.next = null;
        }
    }
}
