import java.util.Arrays;

@SuppressWarnings("all")
class PivotIndex {
    public int pivotIndex(int[] nums) {
        int sumLeft = 0;
        int sumRight = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (sumLeft == (sumRight - (sumLeft + nums[i]))) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(new int[]{2, 1, -1}));
    }
}