import cn.hutool.core.lang.tree.Tree;
import org.solution.common.TreeNode;

@SuppressWarnings("all")
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder,
                          int iLeft, int iRight) {
        if (preLeft > preRight || iLeft > iRight) {
            return null;
        }
        // 前序集合的第一个为根节点
        int headVal = preorder[preLeft];
        // 找到根节点在inorder中的位置
        int index = iLeft;
        while (inorder[index] != preorder[preLeft]) {
            index++;
        }
        TreeNode head = new TreeNode(headVal);
        head.left = build(preorder, preLeft + 1, preLeft + (index - iLeft), inorder, iLeft, index - 1);
        head.right = build(preorder, preLeft + (index - iLeft) + 1, preRight, inorder, index + 1, iRight);
        return head;
    }
}