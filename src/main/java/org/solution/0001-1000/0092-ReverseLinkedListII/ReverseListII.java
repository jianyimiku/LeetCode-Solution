
import org.solution.common.ListNode;

@SuppressWarnings("all")
class ReverseListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode cur = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            cur = cur.next;
            prev = prev.next;
        }
        cur = cur.next;
        for (int i = left; i < right; i++) {
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyHead.next;
    }
}