import org.solution.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("all")
class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int line = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            if (line % 2 == 0) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }
            line++;
            res.add(list);
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        System.out.println(zigzagLevelOrder.zigzagLevelOrder(root));
    }
}