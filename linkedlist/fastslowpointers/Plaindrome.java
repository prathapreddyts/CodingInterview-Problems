package linkedlist.fastslowpointers;

public class Plaindrome {
    public static boolean palindrome(ListNode head) {
        ListNode middleCurrent = head;
        ListNode slowNode = getMiddleNode(middleCurrent);
        ListNode secondHalf = reverseHalf(slowNode);
        ListNode firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true; // Fix here
    }

    public static ListNode getMiddleNode(ListNode current) {
        ListNode slow = current;
        ListNode fast = current;
        while (fast != null && fast.next != null) { // Fix here
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
