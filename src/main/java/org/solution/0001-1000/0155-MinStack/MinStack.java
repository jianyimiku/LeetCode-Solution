import java.util.Stack;

@SuppressWarnings("all")
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        // 用来存储当前的最小值 最小的放在最上面
        minStack = new Stack<>();
    }

    public void push(int val) {
        // 普通栈直接放入
        stack.push(val);

        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            if (minStack.peek() >= val) {
                minStack.push(val);
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        Integer popVal = stack.pop();
        if (popVal.equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException();
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException();
        }
        return minStack.peek();
    }
}

class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}