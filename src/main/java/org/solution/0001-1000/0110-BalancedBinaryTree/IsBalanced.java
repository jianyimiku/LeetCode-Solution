import org.solution.common.TreeNode;

@SuppressWarnings("all")
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
                && Math.abs(checkBalance(root.left) - checkBalance(root.right)) <= 1;
    }


    /**
     * 获取该节点左右子树高度差值
     *
     * @param root
     * @return
     */
    private int checkBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(checkBalance(root.left), checkBalance(root.right)) + 1;
    }
}