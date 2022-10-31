import java.util.Arrays;

@SuppressWarnings("all")
class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int j = nums.length - 2;
        while (j >= 0 && nums[j] >= nums[j + 1]) {
            j--;
        }
        if (j >= 0) {
            int i = nums.length - 1;
            while (i > j && nums[i] <= nums[j]) {
                i--;
            }
            swap(nums, i, j);
        }
        reverse(nums, j + 1, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        NextPermutation nextPermutation
                = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{2,1});
    }
}