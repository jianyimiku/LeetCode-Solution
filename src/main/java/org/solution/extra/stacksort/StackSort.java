package org.solution.extra.stacksort;

import cn.hutool.core.util.ArrayUtil;
import org.solution.common.ArrayUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：sjq
 * @date ：Created in 2023/2/20 12:57
 * @description：
 * @modified By：
 * @version: $
 */
public class StackSort {
    public void stackSort(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            if (!temp.isEmpty()) {
                if (cur <= temp.peek()) {
                    temp.push(cur);
                } else {
                    while (!temp.isEmpty()) {
                        int pop = temp.pop();
                        stack.push(pop);
                        if (cur <= stack.peek()) {
                            temp.push(cur);
                            break;
                        }
                    }
                    if (temp.isEmpty()) {
                        temp.push(cur);
                    }
                }
            } else {
                temp.push(cur);
            }
        }
        Integer[] array = new Integer[10];
        temp.toArray(array);
        System.out.println(Arrays.toString(array));
        System.out.println(ArrayUtil.isSortedDESC(array));
    }


    public static void main(String[] args) {
        Stack<Integer> stack = ArrayUtils.generateStackWithArray(10);
        StackSort sort = new StackSort();
        sort.stackSort(stack);
    }
}
