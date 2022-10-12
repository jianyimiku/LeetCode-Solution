import java.util.Stack;

@SuppressWarnings("all")
class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '[') {
                stack.push(c);
            } else if (c == '{') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (pop != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}