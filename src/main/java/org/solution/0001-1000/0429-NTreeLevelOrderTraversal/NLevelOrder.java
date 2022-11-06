import org.solution.common.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SuppressWarnings("all")
class NLevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> param = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node top = queue.poll();
                param.add(top.val);
                List<Node> children = top.children;
                if (!children.isEmpty()) {
                    children.forEach(node -> {
                        queue.offer(node);
                    });
                }
            }
            res.add(param);
        }
        return res;
    }
}