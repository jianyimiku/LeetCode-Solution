import org.solution.common.TreeNode;

@SuppressWarnings("all")
class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode righeNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode == null) {
            return righeNode;
        }
        if (righeNode == null) {
            return leftNode;
        }
        return root;
    }
}