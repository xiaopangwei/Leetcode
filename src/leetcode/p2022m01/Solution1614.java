package leetcode.p2022m01;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/8
 * @time 10:19 AM
 */
public class Solution1614 {

    public int maxDepth(String s) {
        int              ans   = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                ans = Math.max(ans, stack.size());
            } else if (ch == ')') {
                stack.pop();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1614 solution1614 = new Solution1614();
        int          ans          = solution1614.maxDepth("1");
        System.out.println(ans);
    }
}
