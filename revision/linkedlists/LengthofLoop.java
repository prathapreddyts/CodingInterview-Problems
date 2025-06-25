package revision.linkedlists;

public class LengthofLoop {
    public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countCycleLength(slow);
            }
        }
        return 0;
    }

    private int countCycleLength(ListNode nodeInLoop) {
        ListNode current = nodeInLoop;
        int count = 1;
        while (current.next != nodeInLoop) {
            current = current.next;
            count++;
        }
        return count;
    }

}
