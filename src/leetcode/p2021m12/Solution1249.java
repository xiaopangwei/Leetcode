package leetcode.p2021m12;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/20
 * @time 8:23 PM
 */
public class Solution1249 {

    public String minRemoveToMakeValid(String s) {


        Stack<Integer> stack = new Stack<>();
        boolean[]      flags = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    flags[i] = true;
                    flags[stack.pop()] = true;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '(' && ch != ')') {
                stringBuilder.append(ch);
            } else {
                if (flags[i]) {
                    stringBuilder.append(ch);
                }
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        Solution1249 solution1249 = new Solution1249();
        String       ans          = solution1249.minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(ans);
    }
}
