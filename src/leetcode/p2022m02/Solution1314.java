package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/8
 * @time 10:20 PM
 */
public class Solution1314 {
    // 1 2 3
    // 4 5 6
    // 7 8 9
    private int get(int[][] prefixSum, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return prefixSum[i][j];
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {


        int     maxRows   = mat.length - 1;
        int     maxCols   = mat[0].length - 1;
        int[][] ans       = new int[maxRows + 1][maxCols + 1];
        int[][] prefixSum = new int[maxRows + 1][maxCols + 1];

        for (int i = 0; i <= maxRows; i++) {
            for (int j = 0; j <= maxCols; j++) {
                prefixSum[i][j] = get(prefixSum, i - 1, j) +
                        get(prefixSum, i, j - 1) -
                        get(prefixSum, i - 1, j - 1) +
                        mat[i][j];
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int startX = Math.max(0, i - k);
                int endX   = Math.min(i + k, maxRows);

                int startY = Math.max(0, j - k);
                int endY   = Math.min(j + k, maxCols);


                int cellVal = get(prefixSum, endX, endY) - get(prefixSum, startX - 1, endY)
                        -get(prefixSum, endX, startY - 1)
                        +get(prefixSum, startX - 1, startY - 1);


                ans[i][j] = cellVal;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1314 solution1314 = new Solution1314();
        int[][]      ans          = solution1314.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        System.out.println("-----------");
        for (int[] item : ans) {
            System.out.println(Arrays.toString(item));
        }
    }
}
