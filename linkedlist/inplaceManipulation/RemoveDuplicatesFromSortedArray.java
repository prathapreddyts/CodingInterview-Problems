package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class RemoveDuplicatesFromSortedArray {

    public static ListNode removeDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }

}
