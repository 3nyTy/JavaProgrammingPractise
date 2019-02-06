package design;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stackOriginal = new Stack<Integer>();
    Stack<Integer> stackMinimum = new Stack<Integer>();

    public MinStack() {

    }

    public void push(int x) {
        stackOriginal.push(x);
        if(stackMinimum.isEmpty() || x <=stackMinimum.peek()) {
            stackMinimum.push(x);
        } else {
            stackMinimum.push(stackMinimum.peek());
        }
    }

    public void pop() {
        stackOriginal.pop();
        stackMinimum.pop();

    }

    public int top() {
        return stackMinimum.peek();

    }

    public int getMin() {
        return stackMinimum.pop();
    }

}
