package org.solution.origin.sort;

import org.solution.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author ：sjq
 * @date ：Created in 2023/1/14 14:47
 * @description：归并排序
 * @modified By：
 * @version: $
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] ints = ArrayUtils.generateIntegerArraysWithMaxBounds(100, Integer.MAX_VALUE);
//        int[] origin = Arrays.copyOfRange(ints, 0, ints.length);
//        Arrays.sort(origin);
        mergeSort.mergeSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
//        Assert.isTrue(Arrays.equals(origin, ints));
    }


    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        mergeSort(nums, left, middle);
        mergeSort(nums, middle + 1, right);
        merge(nums, left, right, middle);
    }

    /**
     * 对[left,middle] 和 [middle + 1,right]进行归并
     *
     * @param nums
     * @param left
     * @param right
     * @param middle
     */
    private void merge(int[] nums, int left, int right, int middle) {
        int[] temp = new int[right - left + 1];
        int low = left;
        int high = middle + 1;
        int index = 0;
        while (low <= middle && high <= right) {
            if (nums[low] <= nums[high]) {
                temp[index++] = nums[low];
                low++;
            } else {
                temp[index++] = nums[high];
                high++;
            }
        }

        while (low <= middle) {
            temp[index++] = nums[low++];
        }

        while (high <= right) {
            temp[index++] = nums[high++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[i + left] = temp[i];
        }
    }
}
