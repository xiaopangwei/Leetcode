package leetcode.p2022m03;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 9:56 PM
 */
public class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[]      flag  = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                //不是while
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    flag[stack.pop()] = true;
                    flag[i] = true;
                }

            } else if (ch >= 'a' && ch <= 'z') {
                flag[i] = true;
            }
        }

        System.out.println(Arrays.toString(flag));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (flag[i]) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution1249 solution1249 = new Solution1249();
        String       ans          = solution1249.minRemoveToMakeValid("))((");
        System.out.println(ans);
    }

}
