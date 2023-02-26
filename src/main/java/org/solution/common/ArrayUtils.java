package org.solution.common;

import java.util.Random;
import java.util.Stack;

/**
 * @author ：sjq
 * @date ：Created in 2023/1/12 10:55
 * @description：数组工具类
 * @modified By：
 * @version: $
 */
public class ArrayUtils {
    public static final Random random = new Random();

    /**
     * 随机生成一个数组
     *
     * @param n
     * @return
     */
    public static int[] generateIntegerArrays(int n) {
        return generateIntegerArraysWithMaxBounds(n, Integer.MAX_VALUE);
    }


    public static int[] generateIntegerArraysWithMaxBounds(int n, int max) {
        return random.ints(0, max).limit(n).toArray();
    }


    public static Stack<Integer> generateStackWithArray(int n) {
        int[] ints = generateIntegerArraysWithMaxBounds(n, Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<>();
        for (int i : ints) {
            stack.push(i);
        }
        return stack;
    }
}
