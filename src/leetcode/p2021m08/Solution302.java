package leetcode.p2021m08;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 3:39 PM
 */
public class Solution302 {
    public String removeKdigits(String num, int k) {

        char[]           array = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            if (!stack.isEmpty() || k > 0) {
                while (!stack.isEmpty() && stack.peek() > array[i] && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(array[i]);
            } else {
                stack.push(array[i]);
            }
        }

        if (k != 0) {
            for (int i = 0; i < k; i++) {
                stack.pop();
            }
        }

        int    length = stack.size();
        char[] res    = new char[length];
        int    cnt    = 1;
        while (!stack.isEmpty()) {
            res[length - cnt] = stack.pop();
            cnt++;
        }
        int idx = 0;
        while (idx < length && res[idx] == '0') {
            idx++;
        }

        if (length - idx == 0) {
            return "0";
        }
        return new String(res, idx, length - idx);
    }

    public static void main(String[] args) {
        Solution302 solution302 = new Solution302();
        String      res         = solution302.removeKdigits("10200", 1);
        System.out.println(res);
    }
}
