import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Permute {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] isVisited;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        isVisited = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>());
        return res;
    }


    public void dfs(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                list.add(nums[i]);
                isVisited[i] = true;
                dfs(nums, index + 1, list);
                isVisited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{0,1}));
    }
}