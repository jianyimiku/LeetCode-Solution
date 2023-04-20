import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("all")
public class SubsetsWithDupII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }


    public void dfs(int[] nums, int index, List<Integer> list) {
        if (index <= nums.length) {
            res.add(new ArrayList<>(list));
        }

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsWithDupII subsetsWithDupII = new SubsetsWithDupII();
        System.out.println(subsetsWithDupII.subsetsWithDup(new int[]{1, 2, 2}));
    }
}