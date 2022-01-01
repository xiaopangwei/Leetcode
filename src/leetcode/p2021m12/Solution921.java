package leetcode.p2021m12;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/28
 * @time 10:18 PM
 */
public class Solution921 {
    public int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution921 solution921 = new Solution921();
        int         ans         = solution921.minAddToMakeValid("(((");
        System.out.println(ans);
    }
}
