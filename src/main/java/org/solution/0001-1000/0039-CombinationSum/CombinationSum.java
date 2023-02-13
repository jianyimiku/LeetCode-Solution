import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        calTarget(candidates,0, new ArrayList<>(), target);
        return res;
    }


    private void calTarget(int[] candidates, int index, List<Integer> param, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(param));
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            param.add(candidates[i]);
            calTarget(candidates, i, param, target - candidates[i]);
            param.remove(param.size() - 1);
        }
    }


    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2}, 1));
    }

}