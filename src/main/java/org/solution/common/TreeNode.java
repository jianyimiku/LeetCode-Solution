package org.solution.common;

/**
 * @author ：sjq
 * @date ：Created in 2022/9/17 15:43
 * @description：
 * @modified By：
 * @version: $
 */
public class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
