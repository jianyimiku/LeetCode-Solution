import org.solution.common.ListNode;
import org.solution.common.ListNodeUtil;

@SuppressWarnings("all")
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode var1 = headA;
        ListNode var2 = headB;
        while (var1 != var2) {
            var1 = var1 == null ? headB : var1.next;
            var2 = var2 == null ? headA : var2.next;
        }
        return var1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode headB = new ListNode(5);
        ListNode commonNode = new ListNode(8);
        ListNode commonNode1 = new ListNode(4);
        ListNode commonNode2 = new ListNode(5);
        ListNodeUtil.addNode(headA, 1);
        ListNodeUtil.addListNode(headA, commonNode);
        ListNodeUtil.addListNode(headA, commonNode1);
        ListNodeUtil.addListNode(headA, commonNode2);
        ListNodeUtil.addNodes(headB, 6, 1);
        ListNodeUtil.addListNode(headB, commonNode);

        IntersectionofTwoLinkedLists intersectionofTwoLinkedLists
                = new IntersectionofTwoLinkedLists();
        System.out.println(intersectionofTwoLinkedLists.getIntersectionNode(headA, headB));

    }
}