@SuppressWarnings("all")
class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if (minIndex == 0) {
            return findTarget(nums, minIndex, nums.length - 1, target);
        }
        if (nums[0] > target) {
            return findTarget(nums, minIndex, nums.length - 1, target);
        } else {
            return findTarget(nums, 0, minIndex - 1, target);
        }
    }

    /**
     * 寻找最小元素所在的索引
     *
     * @param nums
     * @return
     */
    private int findMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            // 如果中间的值 大于最右边 最小值在右边
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = right - 1;
            }
        }
        return left;
    }


    private int findTarget(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArray searchinRotatedSortedArray
                = new SearchinRotatedSortedArray();
        System.out.println(searchinRotatedSortedArray.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }
}