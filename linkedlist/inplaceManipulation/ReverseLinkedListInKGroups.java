package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class ReverseLinkedListInKGroups {
    public static ListNode reverseKGroups(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode current = head;
        boolean isNewHeadInitialized = false;
        int length = getLength(head);
        while (length >= k) {
            int grpLen = 0;
            ListNode revHead = null;
            ListNode oldHead = current;
            while (grpLen < k) {
                ListNode nextNode = current.next;
                current.next = revHead;
                revHead = current;
                current = nextNode;
                grpLen++;
            }
            if (!isNewHeadInitialized) {
                newHead = revHead;
                isNewHeadInitialized = true;
            } else {
                newTail.next = revHead;
            }
            newTail = oldHead;
            length -= k;
        }
        if (newTail != null) {
            newTail.next = current;
        }

        return newHead;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

}
