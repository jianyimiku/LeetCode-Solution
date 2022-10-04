import java.util.Stack;

@SuppressWarnings("all")
class CheckValidString {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                    continue;
                }
                if (!star.isEmpty()) {
                    star.pop();
                    continue;
                }
                return false;
            } else {
                star.push(i);
            }
        }

        while (!left.isEmpty() && !star.isEmpty()) {
            // 左括号的数量大于*的数量  ( ( ) ) * ( ( * *
            if (left.size() > star.size()) {
                return false;
            }
            if (left.peek() > star.peek()) {
                return false;
            }
            left.pop();
            star.pop();
        }
        // 左边应该为0
        return left.isEmpty();
    }


    public static void main(String[] args) {
        CheckValidString checkValidString
                = new CheckValidString();
        System.out.println(checkValidString.checkValidString("("));
    }
}