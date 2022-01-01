package leetcode.p2021m12;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 8:22 PM
 */
public class Solution1047 {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char    ch   = S.charAt(i);
            boolean flag = false;
            while (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
                flag = true;
            }
            if (!flag) {
                stack.push(ch);
            }
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution1047 solution1047 = new Solution1047();
        String       ans          = solution1047.removeDuplicates("abbaca");
        System.out.println(ans);
    }
}
