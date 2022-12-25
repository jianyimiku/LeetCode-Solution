package org.solution.common;

import cn.hutool.core.lang.Assert;

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


    /**
     * 根据传入的整数数组生成链表的方法
     *
     * @param a 传入数组
     * @return
     */
    public static ListNode generateListNode(int... a) {
        Assert.notNull(a, "构造链表传入数组不能为空");
        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        for (int j : a) {
            head.next = new ListNode(j);
            head = head.next;
        }
        return dummyHead.next;
    }


    public static void forEachListNode(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
    }
}
