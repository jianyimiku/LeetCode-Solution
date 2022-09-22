/**
 * 排序 用归并实现
 */
@SuppressWarnings("all")
class LargestNumberMergeVersion {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        mergeSort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            stringBuilder.append(nums[i]);
        }
        String result = stringBuilder.toString();
        if (result.charAt(0) == '0') {
            return "0";
        }
        return result;
    }


    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        // 左边归并
        mergeSort(nums, left, middle);
        // 右边归并
        mergeSort(nums, middle + 1, right);
        // 合并数组
        merge(nums, left, middle, right);
    }

    public void merge(int[] nums, int low, int middle, int high) {
        int[] temp = new int[nums.length];
        int i = low;
        int j = middle + 1;
        int index = low;
        while (i <= middle && j <= high) {
            int var1 = nums[i];
            int var2 = nums[j];
            // var1 > var2
            if ((String.valueOf(var1) + String.valueOf(var2)).
                    compareTo(String.valueOf(var2) + String.valueOf(var1)) >= 0) {
                temp[index++] = nums[j];
                j++;
            } else {
                temp[index++] = nums[i];
                i++;
            }
        }
        while (i <= middle) {
            temp[index++] = nums[i++];
        }

        while (j <= high) {
            temp[index++] = nums[j++];
        }
        for (int v = low; v <= high; v++) {
            nums[v] = temp[v];
        }
    }

    public static void main(String[] args) {
        LargestNumberMergeVersion largestNumberMergeVersion
                = new LargestNumberMergeVersion();
        System.out.println(largestNumberMergeVersion.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}