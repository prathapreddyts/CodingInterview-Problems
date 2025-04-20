package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class SwapPairs {


    public ListNode swapPairsUsingTwoPointers(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            int tem = temp.val;
            temp.val = temp.next.val;
            temp.next.val = tem;

            temp = temp.next.next;
        }
        return head;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode lenNode = head;
        if (getLength(lenNode) == 0 || getLength(lenNode) == 1) {
            return head;
        }
        return reverseKGroups(head, 2);
    }

    public static ListNode reverseKGroups(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode current = head;
        boolean isNewHeadInitialized = false;
        int length = getLength(head);
        while (length >= k)
        {
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
