package leetcode.p2022m01;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 10:46 AM
 */
public class SortedStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public SortedStack() {

    }

    public void push(int val) {
        if (stack1.isEmpty()) {
            stack1.push(val);
        } else {
            while (!stack1.isEmpty() && stack1.peek() < val) {
                stack2.push(stack1.pop());
            }

            stack1.push(val);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
    }

    public void pop() {
        stack1.pop();
    }

    public int peek() {
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
