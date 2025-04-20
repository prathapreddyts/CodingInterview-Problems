package linkedlist.fastslowpointers;

public class LengthOfLoop {
    public static int countCycleLength(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                int lenCount=1;
                slow=slow.next;
                while(slow!=fast){
                    lenCount++;
                    slow=slow.next;
                }
                return lenCount;
            }

        }
        return 0;
    }
}
