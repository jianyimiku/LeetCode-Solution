import org.solution.common.ListNode;


/**
 * 重排列表
 */
@SuppressWarnings("all")
class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode front = head;
        ListNode behind = slow.next;
        slow.next = null;

        // 反转behind
        behind = reverseList(behind);
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (front != null && behind != null) {
            temp.next = front;
            temp = temp.next;
            front = front.next;
            temp.next = behind;
            temp = temp.next;
            behind = behind.next;
        }

        if (front != null) {
            temp.next = front;
        }

        if (behind != null) {
            temp.next = behind;
        }

        head = dummyHead.next;
    }


    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        prev.next = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}