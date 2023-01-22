package org.solution.origin.sort;

import cn.hutool.core.util.ArrayUtil;
import org.solution.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author ：sjq
 * @date ：Created in 2023/1/14 15:21
 * @description：快速排序
 * @modified By：
 * @version: $
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] ints = ArrayUtils.generateIntegerArraysWithMaxBounds(20, 10);
        quickSort.quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
        System.out.println(ArrayUtil.isSorted(ints));
    }


    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int partition = getParitionSoltionTwo(nums, left, right);
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }


    public int getParitionSoltionOne(int[] nums, int left, int right) {
        int temp = nums[left];
        int low = left;
        int high = left;
        while (high <= right) {
            if (nums[high] < temp) {
                swap(nums, low + 1, high);
                low++;
            }
            high++;
        }
        swap(nums, left, low);
        return low;
    }

    public int getParitionSoltionTwo(int[] nums, int left, int right) {
        int temp = nums[left];
        int low = left + 1;
        int high = right;
        while (low <= high) {
            while (low <= high && nums[low] < temp) {
                low++;
            }

            while (low <= high && nums[high] >= temp) {
                high--;
            }
            if (low > high) {
                break;
            }
            swap(nums, low, high);
            low++;
            high--;
        }
        swap(nums, left, high);
        return high;
    }


    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
