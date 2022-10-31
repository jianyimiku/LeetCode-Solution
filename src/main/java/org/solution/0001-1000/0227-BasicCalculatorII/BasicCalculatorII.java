import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class BasicCalculatorII {
    public static final HashMap<Character, Integer> maps = new HashMap<>(4);

    static {
        maps.put('+', 0);
        maps.put('-', 0);
        maps.put('*', 1);
        maps.put('/', 1);
    }

    /**
     * 过程和逆波兰表达式的后缀表达式获取很像
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        // 去除所有空格
        s = s.replaceAll(" ", "");
        int n = s.length();
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        // 防止第一位是个负数 需要放入一个0
        nums.offer(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                ops.offer(c);
            } else if (c == ')') {
                // 计算()中的所有符号进行加减
                while (!ops.isEmpty() && ops.peekLast() != '(') {
                    calc(nums, ops.pollLast());
                }
                if (!ops.isEmpty()) {
                    ops.pollLast();
                }
            } else {
                // 如果是数字 把连续的一段数字放入nums
                if (Character.isDigit(c)) {
                    int res = 0;
                    int j = i;
                    while (j < n && Character.isDigit(s.charAt(j))) {
                        res = res * 10 + (s.charAt(j) - '0');
                        j++;
                    }
                    nums.offer(res);
                    i = j - 1;
                } else {
                    // 如果是符号 且操作数栈为空
                    if (ops.isEmpty()) {
                        ops.offer(c);
                    } else if (maps.containsKey(c)) {
                        // 有操作符号要进入但是这个操作数前也是一个操作数的话 那么要保证有一个(+ (0+ 这种 - -2 - 0-2
                        if (i > 0 && (s.charAt(i - 1) == '(' || maps.containsKey(s.charAt(i - 1)))) {
                            nums.offer(0);
                        }
                        // 先把栈内能算的运算符算了
                        while (!ops.isEmpty() && ops.peekLast() != '(') {
                            char prev = ops.pollLast();
                            if (maps.get(prev) >= maps.get(c)) {
                                calc(nums, prev);
                            } else {
                                ops.offer(prev);
                                break;
                            }
                        }
                        ops.offer(c);
                    }
                }
            }
        }

        while (!ops.isEmpty()) {
            calc(nums, ops.pollLast());
        }
        return nums.pollLast();
    }


    private void calc(Deque<Integer> nums, Character ops) {
        if (nums == null || nums.size() < 2) {
            return;
        }
        if (!maps.containsKey(ops)) {
            return;
        }
        Integer num1 = nums.pollLast();
        Integer num2 = nums.pollLast();
        if (ops == '+') {
            nums.offer(num2 + num1);
        } else if (ops == '-') {
            nums.offer(num2 - num1);
        } else if (ops == '*') {
            nums.offer(num2 * num1);
        } else if (ops == '/') {
            nums.offer(num2 / num1);
        }
    }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("1*2-3/4+5*6-7*8+9/10"));
//        System.out.println(basicCalculatorII.calculate("((10 * (6 / ((9 + 3) * -11))) + 17) + 5"));
    }
}