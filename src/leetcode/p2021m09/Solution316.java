package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/15
 * @time 9:07 PM
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {

        char[]           charArray = s.toCharArray();
        Stack<Character> stack     = new Stack<>();

        Map<Character, Integer> valueAndLastIndexRefMap = new HashMap<>();

        for (int i = 0; i < charArray.length; i++) {
            valueAndLastIndexRefMap.put(charArray[i], i);
        }
        boolean[] visited = new boolean[26];

        for (int i = 0; i < charArray.length; i++) {
            char ch  = charArray[i];
            if (visited[ch - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch &&
                    valueAndLastIndexRefMap.getOrDefault(stack.peek(), -1) > i) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }

        int    size = stack.size();
        char[] ans  = new char[size];
        int    k    = size-1;
        for (int i = 0; i < size; i++) {
            ans[k--] = stack.pop();
        }
        return new String(ans);

    }

    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        String      ans         = solution316.removeDuplicateLetters("cbacdcbc");
        System.out.println(ans);
    }
}
