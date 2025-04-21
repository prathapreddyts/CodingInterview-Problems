package linkedlist.inplaceManipulation;

import linkedlist.fastslowpointers.ListNode;

public class SwappingNodes {

    public static ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        ListNode second = head;
        for (int i = 1; i < length - k + 1; i++) {
            second = second.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

        return head;
    }


}
