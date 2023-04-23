import org.solution.common.TreeNode;

import java.util.Stack;

@SuppressWarnings("all")
public class isValidateBST {
    // 中序遍历是升序 判断中序遍历是否升序就可以了
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode last = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode pop = stack.pop();
            if (last != null) {
                if (pop.val <= last.val) {
                    return false;
                }
            }
            last = pop;
            if (pop.right != null) {
                node = pop.right;
            } else {
                node = null;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        isValidateBST isValidateBST = new isValidateBST();
        System.out.println(isValidateBST.isValidBST(root));
    }
}