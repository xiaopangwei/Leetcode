package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/3
 * @time 3:12 PM
 */
public class NumMatrix {

    public int[][] matrix;
    public int[][] dp;

    public NumMatrix(int[][] matrix) {

        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        this.dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public void update(int row, int col, int val) {

        int delta = val - matrix[row][col];

        matrix[row][col] = val;
        for (int i = row + 1; i < dp.length; i++) {
            for (int j = col + 1; j < dp[0].length; j++) {
                dp[i][j] += delta;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }

    public static void main(String[] args) {
        int[][]   array     = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        NumMatrix numMatrix = new NumMatrix(array);
        int       sum       = numMatrix.sumRegion(1, 0, 2, 1);
        System.out.println("sum1:" + sum);

        numMatrix.update(1, 1, 16);
        int sum2 = numMatrix.sumRegion(1, 0, 2, 1);
        System.out.println("sum2:" + sum2);

        int sum3 = numMatrix.sumRegion(1, 0, 2, 3);
        System.out.println("sum3:" + sum3);

    }
}

