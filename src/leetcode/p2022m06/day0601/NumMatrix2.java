package leetcode.p2022m06.day0601;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 9:58 PM
 */
public class NumMatrix2 {

    int[][] prefixSum;
    int[][] matrix;

    int m;
    int n;

    public NumMatrix2(int[][] matrix) {

        this.m = matrix.length;
        this.n = matrix[0].length;
        this.matrix = matrix;
        prefixSum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int s = getSum(matrix, prefixSum, i, j);
                prefixSum[i][j] = s;
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(prefixSum[i]));
        }
    }

    private int getSum(int[][] matrix, int[][] prefixSum, int i, int j) {
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        int t4 = matrix[i][j];
        if (i - 1 >= 0 && j >= 0) {
            t1 = prefixSum[i - 1][j];
        }
        if (i >= 0 && j - 1 >= 0) {
            t2 = prefixSum[i][j - 1];
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
            t3 = prefixSum[i - 1][j - 1];
        }
        return t1 + t2 - t3 + t4;
    }

    public void update(int row, int col, int val) {

        int delta=val-matrix[row][col];
        for (int i = row; i < n; i++) {
            for (int j = col; j < m; j++) {
                prefixSum[i][j] += delta;
            }
        }

        this.matrix[row][col] = val;
    }


    public int sumRegion(int row1, int col1, int row2, int col2) {
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;
        if (row1 >= 1) {
            t1 = prefixSum[row1 - 1][col2];
        }
        if (col1 - 1 >= 0) {
            t2 = prefixSum[row2][col1 - 1];
        }
        if (row1 >= 1 && col1 >= 1) {
            t3 = prefixSum[row1 - 1][col1 - 1];
        }
        return prefixSum[row2][col2] - t1 - t2 + t3;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        NumMatrix2 numMatrix = new NumMatrix2(matrix);
        int        ans       = numMatrix.sumRegion(1, 1, 2, 2);
        System.out.println(ans);
    }
}
