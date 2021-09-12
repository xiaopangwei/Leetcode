package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/12
 * @time 10:34 AM
 */
public class Solution678 {
    private Map<Integer, Boolean> cached = new HashMap<>();

    public boolean checkValidString(String s) {

        return dfs(s, 0, new ArrayList<>());
    }

    private boolean dfs(String s, int index, List<Character> list) {


        if (cached.containsKey(index)) {
            return cached.get(index);
        }
        if (index >= s.length()) {
            System.out.println(list);
            return isValid(list);
        }

        if (s.charAt(index) != '*') {
            list.add(s.charAt(index));
            boolean flag = dfs(s, index + 1, list);
            list.remove(list.size() - 1);
            if (flag) {
                cached.put(index, flag);
            }
            return flag;
        } else {
            boolean flag1 = dfs(s, index + 1, list);
            if (flag1) {
                cached.put(index, true);
                return true;
            }

            list.add('(');
            boolean flag2 = dfs(s, index + 1, list);
            list.remove(list.size() - 1);
            if (flag2) {
                cached.put(index, true);
                return true;
            }


            list.add(')');
            boolean flag3 = dfs(s, index + 1, list);
            list.remove(list.size() - 1);
            if (flag3) {
                cached.put(index, true);
                return true;
            }

            return false;
        }
    }

    private boolean isValid(List<Character> data) {
        Stack<Character> stack = new Stack<>();
        for (char ch : data) {
            if (ch == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty()) {
                    char top = stack.peek();
                    if (top == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution678 solution678 = new Solution678();
        boolean     ans         = solution678.checkValidString("(*))");
        System.out.println(ans);
    }
}
