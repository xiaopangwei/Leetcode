package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/22
 * @time 2:23 PM
 */
public class Solution301 {

    private int error        = 1;
    private int normal       = 2;
    private int unterminated = 3;

    private int isMatch(String s) {
        if (s.length() == 0) {
            return normal;
        }
        char[]           array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : array) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return unterminated;
                } else if (stack.peek() != '(') {
                    return unterminated;
                } else {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            return normal;
        } else {
            return unterminated;
        }
    }


    private List<String> deleteKthChar(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() == 0) {
            return ans;
        } else {

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    ans.add(s.substring(0, i) + s.substring(i + 1, s.length()));
                }
            }
        }
        return ans;
    }

    static class Item {
        public String str;
        public int    times;

        public Item(String str, int times) {
            this.str = str;
            this.times = times;
        }
    }

    public List<String> removeInvalidParentheses(String s) {

        Set<String>  visited = new HashSet<>();
        List<String> ans     = new ArrayList<>();
        Queue<Item>  queue   = new LinkedList<>();
        queue.add(new Item(s, 0));
        int minTimes = -1;
        while (!queue.isEmpty()) {
            Item temp = queue.poll();
            visited.add(temp.str);
            if (minTimes > 0 && temp.times > minTimes) {
                break;
            }
            int res = isMatch(temp.str);
            if (res == normal) {
                if (minTimes == -1) {
                    minTimes = temp.times;
                }
                if (!ans.contains(temp.str)) {
                    ans.add(temp.str);
                }
            } else {
                if (res == unterminated) {
                    List<String> next = deleteKthChar(temp.str);
                    for (String item : next) {
                        if (!visited.contains(item)) {
                            queue.add(new Item(item, temp.times + 1));
                        }
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution301  solution301 = new Solution301();
        List<String> ans         = solution301.removeInvalidParentheses("()(((((((()");
        System.out.println(ans);
    }
}
