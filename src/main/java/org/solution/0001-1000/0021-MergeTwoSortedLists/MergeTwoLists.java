import org.solution.common.ListNode;

@SuppressWarnings("all")
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            head.next = l1;
        } else if (l2 != null) {
            head.next = l2;
        }
        return dummyHead.next;
    }
}