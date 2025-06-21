package revision.linkedlists;

import java.util.List;

public class InsertAtNthPosition {
    public ListNode insertAtKthPosition(ListNode head, int val, int position) {
        // Case: Invalid position
        if (position <= 0) {
            return head;
        }

        // Case: Empty list
        if (head == null) {
            if (position == 1) {
                return new ListNode(val);
            }
            return head;
        }

        // Case: Insert at head
        if (position == 1) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }

        // Case: Insert at valid position or append at end
        ListNode current = head;
        int lengthOfLL = getLengthOfLL(current);
        ListNode lastNode = getLastNode(current);

        if (lengthOfLL < position) {
            //remember this point it will be consider as a edge case
            if (position == lengthOfLL + 1) {
                lastNode.next = new ListNode(val);
            }
        } else {
            insertAtPosition(head, position, val);
        }

        return head;
    }

    public void insertAtPosition(ListNode head, int position, int newValue) {
        ListNode current = head;
        ListNode prev = null;
        // Stop one step before the insertion point
        for (int i = 1; i < position && current != null; i++) {
            prev = current;
            current = current.next;
        }

        // Insert new node between prev and current
        if (prev != null && current != null) {
            ListNode newNode = new ListNode(newValue);
            prev.next = newNode;
            newNode.next = current;
        }
    }

    public ListNode getLastNode(ListNode current) {
        while (current != null && current.next != null) {
            current = current.next;
        }
        return current;
    }

    public int getLengthOfLL(ListNode current) {
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }


}
