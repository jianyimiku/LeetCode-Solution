import java.util.ArrayList;
import java.util.List;


/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
@SuppressWarnings("all")
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list) {
        if (index <= nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subsets(new int[]{0}));
    }

}