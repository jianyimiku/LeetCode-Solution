package org.solution.common;

/**
 * @author ：sjq
 * @date ：Created in 2022/8/25 08:43
 * @description：
 * @modified By：
 * @version: $
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
