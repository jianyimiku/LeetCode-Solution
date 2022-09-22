import org.solution.common.ListNode;

@SuppressWarnings("all")
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cur = 0;
        ListNode one = l1;
        ListNode two = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (one != null && two != null) {
            int val = one.val + two.val + cur;
            int nodeVal = val % 10;
            cur = val / 10;
            head.next = new ListNode(nodeVal);
            head = head.next;
            one = one.next;
            two = two.next;
        }

        while (one != null) {
            int val = one.val + cur;
            int nodeVal = val % 10;
            cur = val / 10;
            head.next = new ListNode(nodeVal);
            head = head.next;
            one = one.next;
        }

        while (two != null) {
            int val = two.val + cur;
            int nodeVal = val % 10;
            cur = val / 10;
            head.next = new ListNode(nodeVal);
            head = head.next;
            two = two.next;
        }

        if (cur != 0) {
            head.next = new ListNode(cur);
        }

        return dummyHead.next;
    }
}