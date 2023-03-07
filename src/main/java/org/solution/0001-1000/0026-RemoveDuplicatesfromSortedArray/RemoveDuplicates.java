@SuppressWarnings("all")
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[j] == nums[i]) {
                j++;
            } else {
                nums[i + 1] = nums[j];
                j++;
                i++;
            }
        }
        return i + 1;
    }
}