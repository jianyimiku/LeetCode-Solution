package org.solution.common;

/**
 * @author ：sjq
 * @date ：Created in 2022/9/8 08:23
 * @description：ListNode工具类
 * @modified By：
 * @version: $
 */
public class ListNodeUtil {
    /**
     * 增加单个Node
     * @param head
     * @param e
     */
    public static void addNode(ListNode head, Integer e) {
        if (head.next == null) {
            head.next = new ListNode(e);
            return;
        }
        addNode(head.next, e);
    }

    public static void addListNode(ListNode head, ListNode e) {
        if (head.next == null) {
            head.next = e;
            return;
        }
        addListNode(head.next, e);
    }

    /**
     * 批量增加Node
     *
     * @param head
     * @param e
     */
    public static void addNodes(ListNode head, Integer... e) {
        int length = e.length;
        for (int i = 0; i < length; i++) {
            addNode(head, e[i]);
        }
    }
}
