import java.util.Arrays;
import java.util.Stack;

@SuppressWarnings("all")
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                res[i] = 0;
                continue;
            } else {
                if (temperatures[i] < temperatures[stack.peek()]) {
                    res[i] = stack.peek() - i;
                } else {
                    while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                        stack.pop();
                    }
                    if (!stack.isEmpty()) {
                        res[i] = stack.peek() - i;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures
                .dailyTemperatures(new int[]{30, 40, 90})));
    }
}