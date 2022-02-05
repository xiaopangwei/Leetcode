package leetcode.p2021m09;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/18
 * @time 9:29 AM
 */
public class Solution32 {
    public int longestValidParentheses(String s) {

        boolean[]      mark  = new boolean[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(i);
            } else {
                if (s.charAt(i) == ')') {
                    if (!stack.isEmpty()) {
                        mark[i] = true;
                        mark[stack.pop()] = true;
                    }
                }
            }
        }


        int i = 0;

        int max = 0;
        while (i < s.length()) {
            if (!mark[i]) {
                i++;
                continue;
            }
            int j = i + 1;

            while (j < s.length() && mark[j]) {
                j++;
            }


            max = Math.max(max, j - i);

            i = j;


        }

        return max;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        int        ans        = solution32.longestValidParentheses(")(()())");
        System.out.println(ans);
    }
}
