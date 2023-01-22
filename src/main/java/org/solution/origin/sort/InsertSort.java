package org.solution.origin.sort;

import org.solution.common.ArrayUtils;

import java.util.Arrays;

/**
 * @author ：sjq
 * @date ：Created in 2023/1/12 10:54
 * @description：插入排序
 * @modified By：
 * @version: $
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] ints = ArrayUtils.generateIntegerArraysWithMaxBounds(10, 1000);
        InsertSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 保证前边有序
     * @param nums
     */
    private static void InsertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
