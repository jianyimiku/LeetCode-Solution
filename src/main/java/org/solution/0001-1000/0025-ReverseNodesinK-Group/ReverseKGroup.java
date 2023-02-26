import org.solution.common.ListNode;


/**
 * @description 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 **/
@SuppressWarnings("all")
public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode end = dummyHead;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            // 开始反转的位置
            ListNode start = prev.next;
            // 下一组的起始位置
            ListNode next = end.next;
            end.next = null;
            // 反转后的头结点
            ListNode reverse = reverseHead(start);
            prev.next = reverse;
            // 将链表回复上去
            start.next = next;
            // 到下一次遍历位置的前一个位置
            prev = start;
            end = prev;
        }
        return dummyHead.next;
    }

    private ListNode reverseHead(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
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