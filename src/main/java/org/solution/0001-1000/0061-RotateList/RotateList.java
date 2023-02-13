
import org.solution.common.ListNode;

@SuppressWarnings("all")
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 计算整个链表的长度
        int cur = 0;
        ListNode cal = head;
        while (cal != null) {
            cur++;
            cal = cal.next;
        }
        int end = k % cur;
        // 提前判断结束 节省时间
        if (end == 0) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < end; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode next = slow.next;
        slow.next = null;
        fast.next = dummyHead.next;
        dummyHead.next = next;

        return dummyHead.next;
    }


    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode listNode = ListNode.generateListNode(0,1,2);
        ListNode res = rotateList.rotateRight(listNode, 4);
        ListNode.forEachListNode(res);
    }
}