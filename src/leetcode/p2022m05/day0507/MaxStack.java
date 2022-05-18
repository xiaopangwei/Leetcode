package leetcode.p2022m05.day0507;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 3:58 PM
 */
public class MaxStack {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MaxStack() {

    }

    public void push(int x) {
        stack1.push(x);
        if (!stack2.isEmpty() && stack2.peek() > x) {
            stack2.push(stack2.peek());
        } else {
            stack2.push(x);
        }
    }

    public int pop() {
        int t = stack1.pop();
        stack2.pop();
        return t;
    }

    public int top() {
        return stack1.peek();
    }

    public int peekMax() {
        return stack2.peek();
    }

    public int popMax() {
        int                 max  = peekMax();
        LinkedList<Integer> list = new LinkedList<>();
        while (top() != max) list.addLast(pop());
        pop();
        while (!list.isEmpty()) push(list.pollLast());
        return max;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(3);
        maxStack.push(2);
        maxStack.push(0);

        System.out.println(maxStack.popMax());

    }
}
