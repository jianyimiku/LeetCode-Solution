
import org.solution.common.ListNode;

@SuppressWarnings("all")
class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;

        while (next != null) {
            // 如果节点相同
            if (prev.val == next.val) {
                // 向后遍历
                while (next != null && prev.val == next.val) {
                    next = next.next;
                }
                if (next == null) {
                    prev.next = null;
                } else {
                    prev.next = next;
                    prev = next;
                    next = next.next;
                }
            } else {
                prev = next;
                next = next.next;
            }
        }
        return head;
    }
}