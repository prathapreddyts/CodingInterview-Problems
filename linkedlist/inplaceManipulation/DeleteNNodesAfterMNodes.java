package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class DeleteNNodesAfterMNodes {
    public static ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode current = head;
        ListNode lastMNode = null;

        while (current != null) {
            int mCount = m;
            while (current != null && mCount > 0) {
                lastMNode = current;
                current = current.next;
                mCount--;
            }

            int nCount = n;
            while (current != null && nCount > 0) {
                current = current.next;
                nCount--;
            }

            if (lastMNode != null) {
                lastMNode.next = current;
            }
        }

        return head;
    }

}
