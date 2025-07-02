package revision.linkedlists.reversebased;

import revision.linkedlists.ListNode;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGrpHelper(head, k);
    }

    public ListNode reverseKGrpHelper(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        int len = getLengthOfLinkedList(head);
        ListNode currentHead = head;
        ListNode newTail = null;
        ListNode newHead = null;

        while (len >= k) {
            ListNode revHead = null;
            ListNode oldHead = currentHead;
            for (int i = 0; i < k; i++) {
                ListNode nextNode = currentHead.next;
                currentHead.next = revHead;
                revHead = currentHead;
                currentHead = nextNode;
            }
            if (newHead == null) {
                newHead = revHead;
            } else {
                newTail.next = revHead;
            }
            newTail = oldHead;
            len -= k;
        }
        newTail.next = currentHead;
        return newHead;
    }


    public int getLengthOfLinkedList(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
