package leetcode.p2022m03;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 10:24 PM
 */
public class Solution402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        int            count = 0;
        boolean[]      flags = new boolean[num.length()];
        Arrays.fill(flags, true);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && num.charAt(stack.peek()) > num.charAt(i)) {
                flags[stack.pop()] = false;
                count++;
                if (count == k) {
                    break;
                }
            }

            if (count == k) {
                break;
            }
            stack.push(i);
        }
        while (count < k) {
            count++;
            flags[stack.pop()] = false;
        }
        for (int i = 0; i < num.length(); i++) {
            if (flags[i]) {
                builder.append(num.charAt(i));
            }
        }
        int i = 0;
        while (i < builder.length() && builder.charAt(i) == '0') {
            i++;
        }
        String sub = builder.substring(i);
        if (sub.isEmpty()) {
            return "0";
        } else {
            return sub;
        }
    }

    public static void main(String[] args) {
        Solution402 solution402 = new Solution402();
        String      ans         = solution402.removeKdigits("10", 1);
        System.out.println(ans);
    }
}
