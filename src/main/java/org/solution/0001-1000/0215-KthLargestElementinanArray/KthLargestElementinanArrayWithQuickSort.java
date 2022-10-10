import java.util.Random;

@SuppressWarnings("all")
class KthLargestElementinanArrayWithQuickSort {
    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;

        // 我们可以知道当pivotIndex小于目标的时候,表示左边都是比pivotIndex小的
        while (true) {
            int pivotIndex = paritionWithThreeWay(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                // pivotIndex > target
                right = pivotIndex - 1;
            }
        }
    }

    /**
     * 单路快速排序
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int paritionWithOneWay(int[] nums, int left, int right) {
        // 防止出现近乎有序的情况 所以需要随机交换第一个元素
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int temp = nums[left];
        int low = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < temp) {
                swap(nums, low + 1, i);
                low++;
            }
        }
        swap(nums, left, low);
        return low;
    }


    /**
     * 双路快排
     * 确定Parition位置
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int paritionWithTwoWay(int[] nums, int left, int right) {
        // 防止出现近乎有序的情况 所以需要随机交换第一个元素
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        // 双路快排
        int temp = nums[left];
        int l = left + 1;
        int r = right;
        while (true) {
            while (l <= right && nums[l] < temp) {
                l++;
            }

            while (l <= right && nums[r] > temp) {
                r--;
            }

            if (l >= r) {
                break;
            }

            swap(nums, l, r);
            l++;
            r--;
        }
        swap(nums, left, r);
        return r;
    }


    /**
     * 三路快速排序
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int paritionWithThreeWay(int[] nums, int left, int right) {
        int randowIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randowIndex);

        // [left,lt] < v [lt+1,gt) == v [gt...last] > v
        int temp = nums[left];
        int lt = left;
        int i = left + 1;
        int gt = right + 1;
        for (int j = i; j < gt; j++) {
            if (nums[j] < temp) {
                swap(nums, lt + 1, j);
                j++;
                lt++;
            } else if (nums[j] > temp) {
                swap(nums, j, gt - 1);
                j++;
                gt--;
            } else {
                j++;
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        KthLargestElementinanArrayWithQuickSort
                largestElementinanArrayWithQuickSort = new KthLargestElementinanArrayWithQuickSort();
        System.out.println(largestElementinanArrayWithQuickSort.findKthLargest(new int[]{-1, 2, 0}, 2));
    }
}