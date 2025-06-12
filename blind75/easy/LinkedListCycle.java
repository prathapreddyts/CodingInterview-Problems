package blind75.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {


    public boolean hasCycleUsingHashing(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (set.contains(current.next)) {
                return true;
            } else {
                current = current.next;
                set.add(current);
            }
        }
        return false;
    }

    public boolean hasCycleFastAndSlowPointer(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            if (slowPointer == fastPointer) {
                return true;
            }

        }
        return false;
    }
}

