package leetcode.p2022m06.day0601;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 9:25 PM
 */
public class Solution1314 {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int     m  = mat.length;
        int     n  = mat[0].length;
        int[][] m1 = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                m1[i][j] = get(m1, i - 1, j) + get(m1, i, j - 1) - get(m1, i - 1, j - 1) + mat[i][j];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = getSum(m1, i, j, k);
            }
        }


        return ans;

    }

    private int get(int[][] array, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return array[i][j];
    }


    private int getSum(int[][] sum, int x, int y, int k) {
        int x1 = Math.max(x - k, 0);
        int y1 = Math.max(y - k, 0);

        int x2 = Math.min(x + k, sum.length - 1);
        int y2 = Math.min(y + k, sum[0].length - 1);
        return sumRegion(sum, x1, y1, x2, y2);
    }

    private int sumRegion(int[][] sum, int x1, int y1, int x2, int y2) {
        return get(sum, x2, y2) - get(sum, x1 - 1, y2) - get(sum, x2, y1 - 1) + get(sum, x1 - 1, y1 - 1);
    }

    public static void main(String[] args) {
        Solution1314 solution1314 = new Solution1314();
        int[][]      matrix       = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ;
        int[][] ans = solution1314.matrixBlockSum(matrix, 1);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
