package leetcode.p2021m12;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 3:12 PM
 */
public class Solution856 {
    public int scoreOfParentheses(String s) {

//        (()(()))
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(0);
            } else {

                if (stack.peek() == 0) {
                    stack.pop();
                    stack.push(1);
                } else {
                    int sum = 0;
                    while (!stack.isEmpty() && stack.peek() != 0) {
                        int t = stack.pop();
                        sum += t;

                    }
                    stack.pop();

                    stack.push(2 * sum);
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;

    }

    public static void main(String[] args) {
        Solution856 solution856 = new Solution856();
        int         ans         = solution856.scoreOfParentheses("(())");
        System.out.println(ans);
    }
}
