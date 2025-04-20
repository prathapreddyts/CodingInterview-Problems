package linkedlist.fastslowpointers;

public class TwinSum {
    public static int twinSum(ListNode head) {
        ListNode current = head;
        ListNode slowNode = getMiddleNode(current);
        ListNode secondHalfHead = reverseHalf(slowNode);
        ListNode firstHalfHead = head;

        int maxValue = Integer.MIN_VALUE;

        while (secondHalfHead != null) {
            int twinSum = secondHalfHead.val + firstHalfHead.val;
            maxValue = Math.max(maxValue, twinSum);

            secondHalfHead = secondHalfHead.next;
            firstHalfHead = firstHalfHead.next;
        }

        return maxValue;
    }

    public static ListNode getMiddleNode(ListNode current) {
        ListNode slow = current;
        ListNode fast = current;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseHalf(ListNode current) {
        ListNode revHead = null;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = revHead;
            revHead = current;
            current = nextNode;
        }
        return revHead;
    }
}
