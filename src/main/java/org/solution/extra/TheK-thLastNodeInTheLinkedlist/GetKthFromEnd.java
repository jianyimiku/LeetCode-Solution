import org.solution.common.ListNode;

@SuppressWarnings("all")
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ListNode listNode = ListNode.generateListNode(1, 2, 3, 4, 5);
        GetKthFromEnd getKthFromEnd = GetKthFromEnd.class.newInstance();
        ListNode.forEachListNode(getKthFromEnd.getKthFromEnd(listNode, 2));
    }
}