import org.solution.common.ListNode;

@SuppressWarnings("all")
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;
    }
}