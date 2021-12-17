package leetcode.p2021m12;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/13
 * @time 10:15 PM
 */
public class Solution1209 {
    static class BiKey {
        char ch;
        int  freq;

        public BiKey(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<BiKey> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                BiKey biKey = stack.peek();
                biKey.freq++;
                if (biKey.freq == k) {
                    stack.pop();
                }
            } else {
                stack.push(new BiKey(ch, 1));
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            BiKey biKey = stack.pop();
            for (int i = 0; i < biKey.freq; i++) {
                stringBuilder.append(biKey.ch);
            }
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution1209 solution1209 = new Solution1209();
        String       ans          = solution1209.removeDuplicates("pbbcggttciiippooaais", 2);
        System.out.println(ans);
    }
}
