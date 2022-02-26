package leetcode.p2022m02;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/22
 * @time 9:46 PM
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String item : tokens) {
            if ("+".equalsIgnoreCase(item) ||
                    "-".equalsIgnoreCase(item) ||
                    "*".equalsIgnoreCase(item) ||
                    "/".equalsIgnoreCase(item)) {
                int b = stack.pop();
                int a = stack.pop();
                if ("+".equalsIgnoreCase(item)) {
                    stack.push(a + b);
                } else if ("-".equalsIgnoreCase(item)) {
                    stack.push(a - b);
                } else if ("*".equalsIgnoreCase(item)) {
                    stack.push(a * b);
                } else if ("/".equalsIgnoreCase(item)) {
                    stack.push(a / b);
                }
            } else {
                stack.push(Integer.parseInt(item));
            }
        }

        return stack.pop();
    }
}
