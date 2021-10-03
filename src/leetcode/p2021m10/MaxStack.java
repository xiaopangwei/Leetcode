package leetcode.p2021m10;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/3
 * @time 1:56 PM
 */
public class MaxStack {
    /**
     * initialize your data structure here.
     */
    Stack<Integer> originalStack = new Stack<>();
    Stack<Integer> maxStack      = new Stack<>();

    public MaxStack() {

    }

    public void push(int x) {
        originalStack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            if (maxStack.peek() < x) {
                maxStack.push(x);
            } else {
                maxStack.push(maxStack.peek());
            }
        }
    }

    public int pop() {
        int res = originalStack.pop();
        maxStack.pop();
        return res;
    }

    public int top() {

        return originalStack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int maxVal = maxStack.peek();

        Stack<Integer> temp = new Stack<>();
        while (!originalStack.isEmpty() && maxVal != originalStack.peek()) {
            temp.push(originalStack.pop());
            maxStack.pop();
        }

        originalStack.pop();
        maxStack.pop();
        int currentMax = Integer.MIN_VALUE;
        if (!maxStack.isEmpty()) {
            currentMax = maxStack.peek();
        }

        while (!temp.isEmpty()) {
            int val = temp.pop();
            originalStack.push(val);
            currentMax = Math.max(currentMax, val);
            maxStack.push(currentMax);
        }
        return maxVal;
    }
}
