import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("all")
class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(target, candidates, 0, new LinkedList<>());
        return res;
    }

    public void dfs(int target, int[] candidates, int index, LinkedList<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return;
        }

        if (index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            // 注意去重条件
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs(target - candidates[i], candidates, i + 1, list);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        System.out.println(combinationSum2.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}