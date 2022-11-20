import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 用栈实现队列
 */
@SuppressWarnings("all")
class ImplementQueueusingStacks {
    Stack<Integer> stackOne = new Stack<>();
    Stack<Integer> stackTwo = new Stack<>();


    public ImplementQueueusingStacks() {

    }

    public void push(int x) {
        while (!stackTwo.isEmpty()) {
            stackOne.push(stackTwo.pop());
        }
        stackOne.push(x);
    }

    public int pop() {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        return stackTwo.pop();
    }

    public int peek() {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        return stackTwo.peek();
    }

    public boolean empty() {
        while (!stackOne.isEmpty()) {
            stackTwo.push(stackOne.pop());
        }
        return stackTwo.isEmpty();
    }
}