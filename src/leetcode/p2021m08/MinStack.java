package leetcode.p2021m08;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 3:31 PM
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> customStack = new Stack<>();
    Stack<Integer> minStack    = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        customStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        customStack.pop();
        minStack.pop();
    }

    public int top() {
        return customStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
