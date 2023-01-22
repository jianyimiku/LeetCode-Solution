package org.solution.origin.sort;

import org.solution.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author ：sjq
 * @date ：Created in 2023/1/12 10:54
 * @description：选择排序
 * @modified By：
 * @version: $
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateIntegerArraysWithMaxBounds(10, 11);
        selectionSort(ints);
        System.out.println(Arrays.toString(ints));
    }


    /**
     * 选择排序 每次选取当前的最小值 进行交换
     * @param nums
     */
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
}
