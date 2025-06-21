package revision.linkedlists;

public class InsertNthPrevPosition {

    public ListNode insertBeforeX(ListNode head, int X, int val) {

        if (head == null) {
            return null;
        }
        if (head.val == X) {
            ListNode newNode = new ListNode(val);
            newNode.next = head;
            return newNode;
        }
        if (head.next == null) {
            return head;
        }
        int position = findPositionOfX(head, X);
        if (position > 0) {
            head = insertAtPosition(head, position, val);
        }
        return head;
    }

    private int findPositionOfX(ListNode head, int X) {
        ListNode current = head;
        int position = 1;
        while (current != null && current.val != X) {
            current = current.next;
            position++;
        }
        return (current != null && current.val == X) ? position : -1;
    }

    private ListNode insertAtPosition(ListNode head, int position, int newValue) {
        ListNode current = head;
        ListNode prev = null;
        for (int i = 1; i < position && current != null; i++) {
            prev = current;
            current = current.next;
        }
        if (prev != null && current != null) {
            ListNode newNode = new ListNode(newValue);
            prev.next = newNode;
            newNode.next = current;
        }

        return head;
    }

}

