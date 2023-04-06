import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class PermuteUnique {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        isVisited = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return res;
    }


    private void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果前面一个没有被遍历过并且相等
            if (i > 0 && !isVisited[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            if (!isVisited[i]) {
                isVisited[i] = true;
                list.add(nums[i]);
                dfs(nums, index + 1, list);
                list.remove(list.size() - 1);
                isVisited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{1, 2, 3}));
    }
}