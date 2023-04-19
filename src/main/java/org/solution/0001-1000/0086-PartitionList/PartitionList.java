import org.solution.common.ListNode;

@SuppressWarnings("all")
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode small = new ListNode(-1);
        ListNode big = new ListNode(-1);
        ListNode cur = head;
        ListNode one = small;
        ListNode two = big;
        while (cur != null) {
            ListNode next = cur.next;
            if (cur.val < x) {
                small.next = cur;
                small = small.next;
            } else {
                big.next = cur;
                big = big.next;
            }
            cur.next = null;
            cur = next;
        }
        small.next = two.next;
        return one.next;
    }
}