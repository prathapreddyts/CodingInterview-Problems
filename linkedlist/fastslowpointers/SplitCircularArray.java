package linkedlist.fastslowpointers;

public class SplitCircularArray {
    public class CircularLinkedListSplitter {

        public static ListNode[] splitCircularLinkedList(ListNode head) {
            if (head == null || head.next == head) {
                return new ListNode[]{head, null};
            }

            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != head && fast.next.next != head) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode head1 = head;
            ListNode head2 = slow.next;

            slow.next = head1; // End first half

            if (fast.next == head) {
                fast.next = head2; // Even nodes
            } else {
                fast.next.next = head2; // Odd nodes
            }

            return new ListNode[]{head1, head2};
        }
    }

}
