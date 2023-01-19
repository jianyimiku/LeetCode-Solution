import org.solution.common.TreeNode;

import java.util.*;

@SuppressWarnings("all")
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair<TreeNode, Integer>> list = new ArrayDeque<>();
        list.add(new Pair<>(root, 1));
        int res = 0;
        while (!list.isEmpty()) {
            int size = list.size();
            res = Math.max(res, (list.peekLast().second - list.peekFirst().second) + 1);
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = list.poll();
                TreeNode cur = pair.first;
                if (cur.left != null) {
                    list.offer(new Pair<>(cur.left, 2 * pair.second));
                }
                if (cur.right != null) {
                    list.offer(new Pair<>(cur.right, 2 * pair.second + 1));
                }
            }
        }
        return res;
    }


    static class Pair<T, U> {
        public T first;

        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}