package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class ReverseBetweenNode {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode prev = null;
        ListNode current = head;

        // Step 1: Move to (left-1)th node
        for (int i = 1; i < left; i++) {
            prev = current;
            current = current.next;
        }

        ListNode revHead = null;
        ListNode tail = current; // Will be the tail of the reversed part
        for (int i = 0; i <= right - left; i++) {
            ListNode next = current.next;
            current.next = revHead;
            revHead = current;
            current = next;
        }
        // Step 3: Reconnect the reversed part
        if (prev != null) {
            prev.next = revHead;
        } else {
            head = revHead; // If left == 1, update head
        }
        tail.next = current;

        return head;
    }


}
