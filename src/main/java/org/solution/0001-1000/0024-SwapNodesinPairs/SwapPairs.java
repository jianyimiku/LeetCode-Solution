
import org.solution.common.ListNode;

@SuppressWarnings("all")
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            ListNode next = fast.next;
            fast.next = slow;
            slow.next = next;
            prev.next = fast;
            prev = slow;
            fast = slow;
        }
        return dummyHead.next;
    }
}