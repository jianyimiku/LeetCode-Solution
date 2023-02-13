import java.util.Stack;

@SuppressWarnings("all")
public class Calculate {

    /**
     * 如果加入 * / 用一个字典存入优先级 前面运算符优先级>=的先计算
     * @param s
     * @return
     */
    public int calculate(String s) {
        // 去除所有的空格
        s = s.replaceAll(" ", "");
        // 用于存放数字
        Stack<Integer> nums = new Stack<>();
        // 用于存放操作符号
        Stack<Character> operation = new Stack<>();
        nums.add(0);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                operation.add(c);
            } else if (c == ')') {
                // 出栈 直到遇到 '(' 因为表达式是合法的
                char ops;
                while (!operation.isEmpty()
                        && (ops = operation.pop()) != '(') {
                    cal(nums, ops);
                }
            } else if (isNum(c)) {
                int j = i;
                int res = 0;
                while (j < n && isNum(s.charAt(j))) {
                    res = res * 10 + s.charAt(j) - '0';
                    j++;
                }
                nums.add(res);
                i = j - 1;
            } else {
                // 1 - (-2)
                if (i > 0 && (s.charAt(i - 1) == '(' || s.charAt(i - 1) == '+' || s.charAt(i - 1) == '-')) {
                    nums.add(0);
                }
                // 新操作需要入栈 需要把前面的运算都酸掉
                while (!operation.isEmpty()
                        && operation.peek() != '(') {
                    cal(nums, operation.pop());
                }
                operation.add(c);
            }
        }
        while (!operation.isEmpty()) {
            cal(nums, operation.pop());
        }
        return nums.pop();
    }


    private void cal(Stack<Integer> num, Character ops) {
        if (num.isEmpty() || num.size() < 2) {
            return;
        }
        Integer var1 = num.pop();
        Integer var2 = num.pop();
        if (ops == '+') {
            num.add(var2 + var1);
        } else if (ops == '-') {
            num.add(var2 - var1);
        }
    }


    private boolean isNum(Character var) {
        return Character.isDigit(var);
    }


    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("1 - (-2)"));
    }
}