package leetcode.p2022m05.day0504;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/4
 * @time 10:44 PM
 */
public class Solution85 {

    public int maximalRectangle(char[][] matrix) {
        int[] prefixSum = new int[matrix[0].length];
        int   ans       = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            prefixSum[i] = matrix[0][i] - '0';
        }
        ans = maxArea(prefixSum);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    prefixSum[j] = 0;
                } else {
                    prefixSum[j] += 1;
                }
            }
            ans = Math.max(ans,maxArea(prefixSum));
        }
        return ans;
    }

    private int maxArea(int[] heights) {
        int[] right = new int[heights.length];
        Arrays.fill(right, -1);
        int[] left = new int[heights.length];
        Arrays.fill(left, heights.length);
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                left[stack.pop()] = i;
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                right[stack.pop()] = i;
            }
            stack.push(i);
        }
        int maxArea = 0;
//        System.out.println("height:" + Arrays.toString(heights));
//        System.out.println("left:" + Arrays.toString(left));
//        System.out.println("right:" + Arrays.toString(right));
        for (int i = 0; i < heights.length; i++) {
            int width = left[i] - (right[i] + 1);
            maxArea = Math.max(width * heights[i], maxArea);
        }
//        System.out.println("maxArea:" + maxArea);
        return maxArea;
    }

    public static void main(String[] args) {
        Solution85 solution85 = new Solution85();
        int        ans        = solution85.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}});
        System.out.println(ans);
    }
}
