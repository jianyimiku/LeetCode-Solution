import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和解法三数之和加一层循环 注意溢出
 */
@SuppressWarnings("all")
public class ForSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= nums.length - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[r - 1] == nums[r]) {
                            r--;
                        }
                        while (l < r && nums[l + 1] == nums[l]) {
                            l++;
                        }
                        r--;
                        l++;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ForSum forSum = new ForSum();
        System.out.println(forSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, 0));
    }
}