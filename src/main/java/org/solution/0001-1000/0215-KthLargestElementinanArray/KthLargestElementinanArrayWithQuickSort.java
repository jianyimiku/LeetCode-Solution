import java.util.Random;

@SuppressWarnings("all")
class KthLargestElementinanArrayWithQuickSort {
    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;

        while (true) {
            int pivotIndex = partition(nums, left, right);
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

    private int partition(int[] nums, int left, int right) {
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

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        KthLargestElementinanArrayWithQuickSort
                largestElementinanArrayWithQuickSort = new KthLargestElementinanArrayWithQuickSort();
        System.out.println(largestElementinanArrayWithQuickSort.findKthLargest(new int[]{-1,2,0}, 2));
    }
}