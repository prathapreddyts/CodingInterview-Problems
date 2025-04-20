package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class RemoveNodesFromLinkedList {
    public static ListNode removeElements(ListNode head, int k) {
        // Step 1: Remove all matching nodes at the beginning (head adjustments)
        while (head != null && head.val == k) {
            head = head.next;
        }

        // Step 2: Now head is either null or a node with val != k
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.next.val == k) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

}
