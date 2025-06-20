package revision.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class TraverseLinkedList {
    public List<Integer> LLTraversal(ListNode head) {
        ArrayList<Integer> resultList = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            resultList.add(current.val);
            current = current.next;
        }
        return resultList;

    }
}
