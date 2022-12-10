import org.solution.common.ListNode;

@SuppressWarnings("all")
class RemoveDuplicatesfromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode backWard = dummyHead;
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
                    backWard.next = null;
                } else {
                    backWard.next = next;
                    prev = next;
                    next = next.next;
                }
            } else {
                backWard = backWard.next;
                prev = next;
                next = next.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.generateListNode(new int[]{1, 1, 1});
        ListNode result = deleteDuplicates(head);
        ListNode.forEachListNode(result);
    }
}