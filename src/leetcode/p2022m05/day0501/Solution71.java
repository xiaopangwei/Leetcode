package leetcode.p2022m05.day0501;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 11:04 PM
 */
public class Solution71 {
    public String simplifyPath(String path) {
        String[]      array = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : array) {
            if (item.isEmpty() || ".".equalsIgnoreCase(item)) {
                continue;
            } else if ("..".equalsIgnoreCase(item)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(item);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append("/");
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
            sb.append("/");
        }

        if (sb.length() > 1 && sb.charAt(sb.length() - 1) == '/') {
            return sb.substring(0, sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        String     ans        = solution71.simplifyPath("/home//foo/");
        System.out.println(ans);

    }
}
