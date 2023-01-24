@SuppressWarnings("all")
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length;
        int j = 0;
        // 我们可以假设[0,left)是0 [left,right) 为1 [right,end] 2
        while (j < right) {
            if (nums[j] == 0) {
                swap(nums, j, left);
                left++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[j] == 2) {
                swap(nums, j, right - 1);
                right--;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}