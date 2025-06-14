package blind75;

public class ReOrderLinkedList {
    public void reorderList(ListNode head) {
        ListNode current = head;
        ListNode firstHalf = head;
        ListNode slowNode = midNode((current));
        ListNode midNode = slowNode.next;
        slowNode.next = null;
        ListNode secondHalf = reverseLinkedList(midNode);
        mergeTwoListNode(firstHalf, secondHalf);
    }

    private void mergeTwoListNode(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;

            l1.next = l2;
            l2.next = tmp1;

            l1 = tmp1;
            l2 = tmp2;
        }
    }


    public ListNode midNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode reverseLinkedList(ListNode currentNode) {
        ListNode revHead = null;
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            currentNode.next = revHead;
            revHead = currentNode;
            currentNode = nextNode;
        }
        return revHead;
    }

}
