package leetcode.p2022m02;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/17
 * @time 10:46 PM
 */
public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        if (isValid(s)) {
            return Arrays.asList(s);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        Set<String> ans  = new HashSet<>();
        boolean     flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (isValid(temp)) {
                    ans.add(temp);
                    flag = true;
                }
                if (!flag) {
                    for (int j = 0; j < temp.length(); j++) {
                        String newStr = temp.substring(0, j) + temp.substring(j + 1);
                        if (!visited.contains(newStr)) {
                            visited.add(newStr);
                            queue.add(newStr);
                        }
                    }
                }
            }
            if (flag) {
                break;
            }
        }

        List<String> res = new ArrayList<>(ans);
        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (count <= 0) {
                    return false;
                } else {
                    count--;
                }
            }
        }

        return count == 0;
    }

    public static void main(String[] args) {
        Solution301  solution301 = new Solution301();
        List<String> ans         = solution301.removeInvalidParentheses(")(");
        System.out.println(ans);
    }
}
