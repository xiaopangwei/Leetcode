package leetcode.p2022m02;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/22
 * @time 9:24 PM
 */
public class Solution907 {
    int maxVal = 1000000007;


    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[]          right = new int[arr.length];
        Arrays.fill(right, arr.length);
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(right));


        stack.clear();

        int[] left = new int[arr.length];
        Arrays.fill(left, -1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
        System.out.println(Arrays.toString(left));
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {

            int  leftBound  = i - (left[i] + 1) + 1;
            int  rightBound = right[i] - 1 - i + 1;
            long width      = (long) leftBound * (long) rightBound;
            System.out.println(i+" "+arr[i]+" "+width);
            long temp       = width * (long) arr[i];
            ans = (ans + temp) % maxVal;

        }
        return (int) ans % maxVal;
    }

    public static void main(String[] args) {
        Solution907 solution907 = new Solution907();
        int         ans         = solution907.sumSubarrayMins(new int[]{71, 55, 82, 55});
        System.out.println(ans);
    }
}
