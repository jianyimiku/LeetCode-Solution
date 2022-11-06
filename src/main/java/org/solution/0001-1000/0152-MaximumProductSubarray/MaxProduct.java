@SuppressWarnings("all")
class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int iMax = 1;
        int iMin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = iMin;
                iMin = iMax;
                iMax = temp;
            }
            iMax = Math.max(nums[i] * iMax, nums[i]);
            iMin = Math.min(nums[i] * iMin, nums[i]);
            max = Math.max(max, iMax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{2, -1, 1, 1}));
    }
}