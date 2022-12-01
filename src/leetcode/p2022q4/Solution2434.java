package leetcode.p2022q4;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/29
 * @time 10:01 PM
 */
public class Solution2434 {
    public String robotWithString(String s) {
        int[] cnt = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            cnt[s.charAt(i) - 'a'] += 1;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder    sb    = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            cnt[s.charAt(i) - 'a']--;

            int minIndex = -1;
            for (int t = 0; t < cnt.length; t++) {
                if (cnt[t] > 0) {
                    minIndex = t;
                    break;
                }
            }
            while (!stack.isEmpty() && stack.peek() - 'a' < minIndex) {
                sb.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution2434 solution2434 = new Solution2434();
        System.out.println(solution2434.robotWithString("bydizfve"));
    }

}
