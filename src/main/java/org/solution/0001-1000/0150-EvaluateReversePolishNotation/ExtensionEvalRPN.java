//import java.util.*;
//
///**
// * BUG不少 1 — (     -2) 这种怎么化
// */
//@SuppressWarnings("all")
//public class ExtensionEvalRPN {
//    // 存储优先级
//    public static final Map<Character, Integer> maps = new HashMap<>(4);
//
//    static {
//        maps.put('+', 0);
//        maps.put('-', 0);
//        maps.put('*', 1);
//        maps.put('/', 1);
//    }
//
//    /**
//     * 根据中缀表达式获得后缀表达式
//     *
//     * @param expression
//     */
//    public String[] getEvalRPN(String expression) {
//        ArrayDeque<Character> operations = new ArrayDeque<>();
//        ArrayDeque<String> nums = new ArrayDeque<>();
//        if (expression == null || expression.length() == 0) {
//            return new String[]{};
//        }
//        char[] expressionArray = expression.toCharArray();
//        boolean lastIsDigit = false;
//        for (char c : expressionArray) {
//            // 如果是数字直接存入
//            if (Character.isDigit(c)) {
//                if (lastIsDigit) {
//                    String lastNum = nums.pollLast();
//                    nums.offer(lastNum + c);
//                } else {
//                    nums.offer(String.valueOf(c));
//                }
//                lastIsDigit = true;
//            } else if (c == '(') {
//                operations.offer(c);
//                lastIsDigit = false;
//            } else if (maps.containsKey(c)) {
//                // 如果是加减乘除
//                if (operations.isEmpty()) {
//                    operations.offer(c);
//                } else {
//                    char topOperation = operations.pollLast();
//                    if (topOperation == '(') {
//                        operations.offer(topOperation);
//                        operations.offer(c);
//                    } else if (maps.get(c) > maps.get(topOperation)) {
//                        operations.offer(topOperation);
//                        operations.offer(c);
//                    } else {
//                        nums.offer(String.valueOf(topOperation));
//                        operations.offer(c);
//                    }
//                }
//                lastIsDigit = false;
//            } else if (c == ')') {
//                while (operations.peekLast() != '(') {
//                    char topOperation = operations.pollLast();
//                    nums.offer(String.valueOf(topOperation));
//                }
//                operations.pollLast();
//                lastIsDigit = false;
//            }
//        }
//
//        while (!operations.isEmpty()) {
//            char topOperation = operations.pollLast();
//            nums.offer(String.valueOf(topOperation));
//        }
//        return nums.toArray(new String[0]);
//    }
//
//
//    public static void main(String[] args) {
//        ExtensionEvalRPN evalRPN = new ExtensionEvalRPN();
//        String[] expression = evalRPN.getEvalRPN("((10 * (6 / ((9 + 3) * -11))) + 17) + 5");
//        System.out.println(Arrays.toString(expression));
//    }
//}