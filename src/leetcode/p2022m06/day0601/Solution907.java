package leetcode.p2022m06.day0601;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/4
 * @time 2:43 PM
 */
public class Solution907 {
    final int mod = (int) 10e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack1 = new Stack<>();
        int[]          left   = new int[arr.length];
        Arrays.fill(left, arr.length);

        Stack<Integer> stack2 = new Stack<>();
        int[]          right  = new int[arr.length];
        Arrays.fill(right, -1);
        for (int i = 0; i < arr.length; i++) {
            if (stack1.isEmpty()) {
                stack1.push(i);
            } else {
                while (!stack1.isEmpty() && arr[stack1.peek()] > arr[i]) {
                    left[stack1.pop()] = i;
                }
                stack1.push(i);
            }
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack2.isEmpty()) {
                stack2.push(i);
            } else {
                while (!stack2.isEmpty() && arr[stack2.peek()] > arr[i]) {
                    right[stack2.pop()] = i;
                }
                stack2.push(i);
            }
        }
        long ans = 0;

        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(left));
        for (int i = 0; i < arr.length; i++) {
            int width = (i - right[i]) * (left[i] - i);
            ans += width * arr[i];
            ans = ans % mod;
        }
        return (int) ans % mod;
    }

    public static void main(String[] args) {
        Solution907 solution907 = new Solution907();
        int         ans         = solution907.sumSubarrayMins(new int[]{11, 81, 94, 43, 3});
        System.out.println(ans);
    }

}
