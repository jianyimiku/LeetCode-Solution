import java.util.Arrays;

@SuppressWarnings("all")
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j < 2 || nums[i - 2] != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII removeDuplicatesII = new RemoveDuplicatesII();
        System.out.println(removeDuplicatesII.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

}