package leetcode.p2021m12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 11:16 AM
 */
public class Solution1190 {
    //(u(love)i)
    public String reverseParentheses(String s) {
        Stack<Character> stack         = new Stack<>();
        Queue<Character> reversedQueue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    reversedQueue.add(stack.pop());
                }
                stack.pop();
                while (!reversedQueue.isEmpty()) {
                    stack.push(reversedQueue.poll());
                }

            } else {
                stack.push(ch);
            }
        }

        StringBuilder stringBuilder=new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args){
        Solution1190 solution1190=new Solution1190();
        String ans=solution1190.reverseParentheses("a(bcdefghijkl(mno)p)q");
        System.out.println(ans);
    }
}
