package leetcode.p2022m05.day0505;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 10:30 PM
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
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
        for (int i = 0; i < heights.length; i++) {
            int width = left[i] - (right[i] + 1);
            int minVal=Math.min(width,heights[i]);
            maxArea = Math.max(minVal*minVal, maxArea);
        }
        return maxArea;
    }
}
