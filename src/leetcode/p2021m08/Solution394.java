package leetcode.p2021m08;

import java.util.LinkedList;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 2:24 PM
 */
public class Solution394 {
    public String decodeString(String s) {

        char[]         array     = s.toCharArray();
        Stack<String>  charStack = new Stack<>();
        Stack<Integer> numStack  = new Stack<>();
        int            length    = array.length;
        int            repeat    = 0;
        for (int i = 0; i < length; i++) {
            char ch = array[i];
            if (ch >= 'a' && ch <= 'z') {
                charStack.push(String.valueOf(ch));
            } else if (ch >= '0' && ch <= '9') {
                repeat = repeat * 10 + (ch - '0');
            } else if (ch == '[') {
                numStack.push(repeat);
                repeat = 0;
                charStack.push(String.valueOf("["));
            } else {
                LinkedList<String> resList = new LinkedList<>();
                while (!charStack.isEmpty() && !charStack.peek().equals("[")) {
                    resList.addFirst(charStack.pop());
                }

                charStack.pop();
                String        loop    = String.join("", resList);
                int           times   = numStack.pop();
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    builder.append(loop);
                }
                charStack.push(builder.toString());
            }
        }

        LinkedList<String> ans = new LinkedList<>();
        while (!charStack.isEmpty()) {
            ans.addFirst(charStack.pop());
        }
        return String.join("", ans);
    }

    public static void main(String[] args) {
        Solution394 solution394 = new Solution394();
        String      ans         = solution394.decodeString("11[ab]12[ac]");
        System.out.println(ans);
    }
}
