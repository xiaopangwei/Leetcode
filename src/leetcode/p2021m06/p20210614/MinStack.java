package leetcode.p2021m06.p20210614;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/18
 * @time 2:47 PM
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return 0;
    }
}
