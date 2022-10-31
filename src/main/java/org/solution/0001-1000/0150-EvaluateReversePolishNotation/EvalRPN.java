import java.util.Stack;

@SuppressWarnings("all")
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stringStack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+")) {
                int num1 = Integer.parseInt(stringStack.pop());
                int num2 = Integer.parseInt(stringStack.pop());
                int res = num2 + num1;
                stringStack.push(String.valueOf(res));
            } else if (str.equals("-")) {
                int num1 = Integer.parseInt(stringStack.pop());
                int num2 = Integer.parseInt(stringStack.pop());
                int res = num2 - num1;
                stringStack.push(String.valueOf(res));
            } else if (str.equals("*")) {
                int num1 = Integer.parseInt(stringStack.pop());
                int num2 = Integer.parseInt(stringStack.pop());
                int res = num2 * num1;
                stringStack.push(String.valueOf(res));
            } else if (str.equals("/")) {
                int num1 = Integer.parseInt(stringStack.pop());
                int num2 = Integer.parseInt(stringStack.pop());
                int res = num2 / num1;
                stringStack.push(String.valueOf(res));
            } else {
                stringStack.push(str);
            }
        }
        return Integer.parseInt(stringStack.pop());
    }

//    public static void main(String[] args) {
//        EvalRPN evalRPN = new EvalRPN();
//        System.out.println(evalRPN.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
//    }
}