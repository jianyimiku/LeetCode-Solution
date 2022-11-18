import org.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
@SuppressWarnings("all")
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            TreeNode cur = nodes.pop();
            res.add(cur.val);
            if (cur.right != null) {
                node = cur.right;
            } else {
                node = null;
            }
        }
        return res;
    }
}