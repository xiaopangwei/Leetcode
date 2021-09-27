package leetcode.p2021m09;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 10:01 PM
 */
public class Solution439 {
    public String parseTernary(String expression) {

        int              i     = expression.length() - 1;
        Stack<Character> stack = new Stack<>();
        while (i >= 0) {
            char ch = expression.charAt(i);
            if (ch != '?') {
                stack.push(ch);
                i--;
            } else {
                int  j = i - 1;
                char a = stack.pop();
                stack.pop();
                char b = stack.pop();

                if (expression.charAt(j) == 'T') {
                    stack.push(a);
                } else {
                    stack.push(b);
                }

                i = j - 1;
            }
        }
        return String.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        Solution439 solution439 = new Solution439();
        String      ans         = solution439.parseTernary("T?T?F:5:3");
        System.out.println(ans);
    }
}
