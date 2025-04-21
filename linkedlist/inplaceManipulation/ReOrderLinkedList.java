package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class ReOrderLinkedList {

    public static ListNode reorderList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Step 1: Find the middle of the list
        ListNode mid = findMiddleNode(head);
        ListNode second = mid.next;
        mid.next = null;
        second = reverseSecondHalf(second);
        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }

        return head;
    }

    public static ListNode findMiddleNode(ListNode current) {
        ListNode slow = current;
        ListNode fast = current;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseSecondHalf(ListNode current) {
        ListNode revHead = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = revHead;
            revHead = current;
            current = next;
        }
        return revHead;
    }
}

