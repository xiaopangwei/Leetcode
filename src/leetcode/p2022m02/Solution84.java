package leetcode.p2022m02;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 4:23 PM
 */
public class Solution84 {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        //左边第一个比它小的
        int[] left = new int[heights.length];
        //右边第一个比它小的
        int[] right = new int[heights.length];

        Arrays.fill(right, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }

//        System.out.println(Arrays.toString(right));
        Arrays.fill(left, -1);
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }
//        System.out.println(Arrays.toString(left));

        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int rightBoundIndex = right[i] - 1;
            int leftBoundIndex  = left[i] + 1;

            int width = rightBoundIndex - leftBoundIndex + 1;
            maxVal = Math.max(maxVal, width * heights[i]);
        }

        return Math.max(0, maxVal);
    }

    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        int        ans        = solution84.largestRectangleArea(new int[]{2, 4});
        System.out.println(ans);
    }
}
