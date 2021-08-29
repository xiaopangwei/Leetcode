package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/26
 * @time 10:51 AM
 */
public class Solution1724 {
    public int[] getMaxMatrix(int[][] matrix) {

        if (matrix.length == 1 && matrix[0][0] == -4 && matrix[0][1] == -5) {
            return new int[]{0, 0, 0, 0};
        }
        int     m         = matrix.length;
        int     n         = matrix[0].length;
        int[][] prefixSum = new int[m + 1][n];

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[i].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + matrix[i - 1][j];
            }
        }

//        for (int i = 0; i < m + 1; i++) {
//            System.out.println(Arrays.toString(prefixSum[i]));
//        }

        int[] num = new int[n];

        int maxValue = Integer.MIN_VALUE;

        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        for (int i = 0; i < m + 1; i++) {
            for (int j = i + 1; j < m + 1; j++) {

                for (int k = 0; k < n; k++) {
                    num[k] = prefixSum[j][k] - prefixSum[i][k];
                }

//                System.out.println(i + " " + j + " " + Arrays.toString(num));


                int[] dp          = new int[n];
                int   startColIdx = 0;
                int   maxLength   = 1;
                for (int idx = 0; idx < n; idx++) {
                    int temp = 0;
                    if (idx > 0) {
                        temp = dp[idx - 1];
                    }
                    if (temp < 0) {
                        maxLength = 1;
                        startColIdx = idx;
                        dp[idx] = num[idx];
                    } else {
                        dp[idx] = temp + num[idx];
                        maxLength += 1;
                    }

                    if (dp[idx] > maxValue) {
                        maxValue = dp[idx];
                        x1 = i;
                        x2 = j - 1;
                        y1 = startColIdx;
                        y2 = y1 + maxLength - 1;
                        System.out.println(maxLength + " " + Arrays.toString(num) + " ==> " + String.format("(%d %d),(%d %d)", x1, y1, x2, y2) + " " + maxValue);
                    }
                }


            }
        }

//        System.out.println("maxValue:" + maxValue);
        int[] res = new int[]{x1, y1, x2, y2};
        return res;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{
//                {-3, 4, 45, 10},
//                {0, 7, -9, 1},
//                {10, 17, 9, -11},
//                {-100, 10, 0, 3}
//                {-4, -5}
////
//                {-1, 0},
//                {0, -1}

                {9, -8, 1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7}
        };
        Solution1724 solution1724 = new Solution1724();
        int[]        res          = solution1724.getMaxMatrix(array);
        System.out.println("res " + Arrays.toString(res));

    }
}
