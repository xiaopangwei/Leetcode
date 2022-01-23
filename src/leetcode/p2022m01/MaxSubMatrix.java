package leetcode.p2022m01;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/22
 * @time 11:40 PM
 */
public class MaxSubMatrix {
    //   [-1,0]
    //    [0,-1]
    public int[] getMaxMatrix(int[][] matrix) {
        int[][] prefixSum = new int[matrix.length + 1][matrix[0].length];
        Arrays.fill(prefixSum[0], 0);
        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i - 1][j];
            }
        }

        int x1     = 0, y1 = 0, x2 = 0, y2 = 0;
        int maxVal = Integer.MIN_VALUE;

        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {

                int[] gapArray = getGap(prefixSum, i, j);
                int[] temp     = getMaxSubMatrixOfOndDimension(gapArray);

                if (temp[0] > maxVal) {

                    x1 = i;
                    x2 = j - 1;
                    y1 = temp[1];
                    y2 = temp[1] + temp[2] - 1;
                    maxVal = temp[0];
                }
            }
        }

        return new int[]{x1, y1, x2, y2};
    }


    private int[] getGap(int[][] prefixSum, int row1, int row2) {
        int   cols = prefixSum[0].length;
        int[] ans  = new int[cols];

        for (int i = 0; i < cols; i++) {
            ans[i] = prefixSum[row2][i] - prefixSum[row1][i];
        }
        return ans;
    }

    private int[] getMaxSubMatrixOfOndDimension(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        int start           = 0;
        int len             = 1;
        int startIndexOfMax = 0;
        int lengthOfMax     = 1;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
                len++;
            } else {
                start = i;
                len = 1;
                dp[i] = nums[i];
            }
            if (dp[i] > max) {
                startIndexOfMax = start;
                lengthOfMax = len;
                max = dp[i];
            }
        }

        return new int[]{max, startIndexOfMax, lengthOfMax};
    }

    public static void main(String[] args) {
        MaxSubMatrix maxSubMatrix = new MaxSubMatrix();
        int[]        t1           = maxSubMatrix.getMaxSubMatrixOfOndDimension(new int[]{-4, 9});
//        System.out.println(Arrays.toString(t1));
        int[] ans = maxSubMatrix.getMaxMatrix(new int[][]{{9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}});
        System.out.println(Arrays.toString(ans));
    }
}
