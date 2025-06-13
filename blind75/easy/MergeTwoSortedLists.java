package blind75.easy;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        while (list1 != null && list2 != null) {
            ListNode newNode;
            if (list1.val < list2.val) {
                newNode = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newNode = new ListNode(list2.val);
                list2 = list2.next;
            }

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        if (head == null) {
            return (list1 != null) ? list1 : list2;
        }

        while (list1 != null) {
            tail.next = new ListNode(list1.val);
            tail = tail.next;
            list1 = list1.next;
        }
        while (list2 != null) {
            tail.next = new ListNode(list2.val);
            tail = tail.next;
            list2 = list2.next;
        }

        return head;
    }


}
