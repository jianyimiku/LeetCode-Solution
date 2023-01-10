import org.solution.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@SuppressWarnings("all")
class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> nodes = new Stack<>();
        TreeNode node = root;
        while (node != null || !nodes.isEmpty()) {
            while (node != null) {
                res.add(node.val);
                nodes.add(node);
                node = node.left;
            }
            node = nodes.pop();
            if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        return res;
    }
}