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

    private int[][] sum;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m + 1][n + 1];
        this.matrix = matrix;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        row1++;
        row2++;
        col1++;
        col2++;
        return sum[row2][col2] - sum[row1-1][col2] - sum[row2][col1-1] + sum[row1-1][col1-1];
    }

    public static void main(String[] args) {
        int[][]   array     = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NumMatrix numMatrix = new NumMatrix(array);
        int       sum       = numMatrix.sumRegion(1, 0, 2, 1);
        System.out.println(sum);
    }
}

