package org.solution.origin.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：sjq
 * @date ：Created in 2023/1/12 10:01
 * @description：冒泡排序
 * @modified By：
 * @version: $
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据的长度");
        int n = scanner.nextInt();
        int[] params = new int[n];
        int i = 0;
        while (i < n) {
            System.out.println("请输入数组第" + (i + 1) + "个数据");
            params[i++] = scanner.nextInt();
        }
        bubbleSort(params);
        System.out.println(Arrays.toString(params));
    }


    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
