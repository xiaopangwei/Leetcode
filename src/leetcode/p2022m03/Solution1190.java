package leetcode.p2022m03;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/28
 * @time 9:09 PM
 */
public class Solution1190 {
    public String reverseParentheses(String s) {
        Stack<Integer> stack1 = new Stack<>();

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (s.charAt(i) == '(') {
                stack1.push(i);
            }
            if (s.charAt(i) == ')') {
                reverse(array, stack1.pop() + 1, i - 1);
            }
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (array[i] != '(' && array[i] != ')') {
                builder.append(array[i]);
            }
        }

        return builder.toString();
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution1190 solution1190 = new Solution1190();
        String       ans          = solution1190.reverseParentheses("a(bcdefghijkl(mno)p)q");
        System.out.println(ans);
    }
}


