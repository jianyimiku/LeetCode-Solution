import java.util.Arrays;

@SuppressWarnings("all")
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = findLeftPosition(nums, target);
        int r = findRightPosition(nums, target);
        return new int[]{l, r};
    }


    public int findLeftPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int middle = l + (r - l) / 2;
            // 排序数据 等于目标值 那么目标可能还在左边
            if (nums[middle] == target) {
                r = middle;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }


    public int findRightPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int middle = l + (r - l + 1) / 2;
            if (nums[middle] == target) {
                l = middle;
            } else if (nums[middle] > target) {
                r = middle - 1;
            } else {
                l = middle + 1;
            }
        }
        return nums[r] == target ? r : -1;
    }

    public static void main(String[] args) {
        SearchRange range = new SearchRange();
        System.out.println(Arrays.toString(range.searchRange(new int[]{}, 0)));
    }
}