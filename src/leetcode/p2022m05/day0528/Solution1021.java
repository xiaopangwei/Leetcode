package leetcode.p2022m05.day0528;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/28
 * @time 11:17 AM
 */
public class Solution1021 {
    public String removeOuterParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        boolean[]      flag  = new boolean[s.length()];
        Arrays.fill(flag, true);
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else {
                    if (stack.size() > 1) {
                        stack.pop();
                    } else {
                        flag[i] = false;
                        flag[stack.pop()] = false;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s="()()";
        Solution1021 solution1021=new Solution1021();
        String newS=solution1021.removeOuterParentheses(s);
        System.out.println(newS);
    }
}
