import org.solution.common.TreeNode;

@SuppressWarnings("all")
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 反转左边
        TreeNode left = invertTree(root.left);
        // 反转右边
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}