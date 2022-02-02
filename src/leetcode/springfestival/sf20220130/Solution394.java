package leetcode.springfestival.sf20220130;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 11:04 AM
 */
public class Solution394 {
    public String decodeString(String s) {
        Stack<String>  stack1     = new Stack<>();
        Stack<Integer> stack2     = new Stack<>();
        int            i          = 0;
        int            repeatTime = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack2.push(repeatTime);
                repeatTime = 0;
                stack1.push("[");
            } else if (ch == ']') {
                LinkedList<String> linkedList = new LinkedList<>();
                while (!stack1.isEmpty() && !"[".equals(stack1.peek())) {
                    linkedList.addFirst(stack1.pop());
                }
                stack1.pop();
                String        t      = String.join("", linkedList);
                int           temp   = stack2.pop();
                StringBuilder concat = new StringBuilder();
                for (int j = 0; j < temp; j++) {
                    concat.append(t);
                }
                stack1.push(concat.toString());
            } else if (ch >= 'a' && ch <= 'z') {
                stack1.push(String.valueOf(ch));
            } else {
                repeatTime = repeatTime * 10 + ch - '0';
            }
            i++;
        }

        LinkedList<String> ans = new LinkedList<>();
        while (!stack1.isEmpty()) {
            ans.addFirst(stack1.pop());
        }

        return String.join("", ans);
    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String      ans         = solution394.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
        System.out.println(ans);
    }
}
