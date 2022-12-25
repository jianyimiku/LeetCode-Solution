import org.solution.common.ListNode;

@SuppressWarnings("all")
class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 排序
        return mergeSort(head);
    }

    /**
     * 分隔链表
     *
     * @param head
     * @return
     */
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode nodePrev = mergeSort(head);
        ListNode nodeNext = mergeSort(next);
        return merge(nodePrev, nodeNext);
    }

    /**
     * 链表合并
     *
     * @param prev
     * @param next
     */
    public ListNode merge(ListNode prev, ListNode next) {
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        while (prev != null && next != null) {
            if (prev.val <= next.val) {
                head.next = new ListNode(prev.val);
                prev = prev.next;
            } else {
                head.next = new ListNode(next.val);
                next = next.next;
            }
            head = head.next;
        }
        if (prev != null) {
            head.next = prev;
        }
        if (next != null) {
            head.next = next;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.generateListNode(new int[]{-1, 5, 3, 4, 0});
        SortList sortList = new SortList();
        ListNode.forEachListNode(sortList.sortList(listNode));
    }
}