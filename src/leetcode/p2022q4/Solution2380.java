package leetcode.p2022q4;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/5
 * @time 10:40 PM
 */
public class Solution2380 {
    public int secondsToRemoveOccurrences(String s) {

        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int count=0;
        while (i < s.length()) {
            if (!stack.isEmpty() && stack.peek() == 0 && s.charAt(i) == '1') {
                stack.pop();
                count++;
                stack.push(1);
                stack.push(0);
            }else{
                stack.push(s.charAt(i)-'0');
            }
            i++;
        }

        return count;
    }

    public static void main(String[] args){
        Solution2380 solution2380=new Solution2380();
        System.out.println(solution2380.secondsToRemoveOccurrences("11100"));
    }
}
