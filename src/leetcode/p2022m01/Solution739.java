package leetcode.p2022m01;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 3:27 PM
 */
public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        int[]          res   = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int t = stack.peek();
                res[t] = i - t;
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[]       ans         = solution739.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
        System.out.println(Arrays.toString(ans));
    }
}
