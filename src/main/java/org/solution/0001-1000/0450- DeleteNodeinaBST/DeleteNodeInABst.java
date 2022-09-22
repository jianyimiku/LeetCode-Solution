import org.solution.common.TreeNode;

@SuppressWarnings("all")
public class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }
        // 判断当前key是否是自己想要的
        if (root.val == key){
            if (root.right == null){
                return root.left;
            }else {
                TreeNode right = root.right;
                TreeNode cur = right;
                while (cur != null && cur.left != null){
                    cur = cur.left;
                }
                cur.left = root.left;
                root.left = null;
                root.right = null;
                return right;
            }
        }
        root.left = deleteNode(root.left,key);
        root.right = deleteNode(root.right, key);
        return root;
    }
}