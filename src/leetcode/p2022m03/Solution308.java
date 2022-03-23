package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 10:48 PM
 */
public class Solution308 {
    int[][] matrix;
    int[][] sum;
    int     rows;
    int     cols;

    public Solution308(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = matrix;

        sum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int a = i - 1 >= 0 ? sum[i - 1][j] : 0;
                int b = j - 1 >= 0 ? sum[i][j - 1] : 0;
                int c = j - 1 >= 0 && i - 1 >= 0 ? sum[i - 1][j - 1] : 0;
                sum[i][j] = a + b - c + matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - this.matrix[row][col];
        this.matrix[row][col] = val;
        for (int i = row; i < this.rows; i++) {
            for (int j = col; j < this.cols; j++) {
                sum[i][j] += delta;
            }
        }

        System.out.println(row + " " + col + " =>" + val);
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(sum[i]));
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == row2 && col1 == col2) {
            return matrix[row1][col1];
        }

        int t2 = 0;
        if (row1 - 1 >= 0) {
            t2 = sum[row1 - 1][col2];
        }

        int t3 = 0;
        if (col1 - 1 >= 0) {
            t3 = sum[row2][col1 - 1];
        }

        int t4 = 0;
        if (col1 - 1 >= 0 && row1 - 1 >= 0) {
            t4 = sum[row1 - 1][col1 - 1];
        }
        return sum[row2][col2] - t2 - t3 + t4;
    }

    public static void main(String[] args) {
//        ["NumMatrix", "sumRegion", "sumRegion", "sumRegion", "update", "update", "sumRegion"]
//[[[[1,2]]],[0,0,0,0],[0,1,0,1],[0,0,0,1],[0,0,3],[0,1,5],[0,0,0,1]]
//[[[[0,-3,-8,3],[-9,3,5,3],[2,3,-5,3]]],[0,1,9],[1,0,-7],[2,2,2,3],[1,3,1,3],[2,3,2,3],[0,3,-3],[2,3,2,3],[0,3,0,3],[1,2,1,3],[1,2,-5]]
        int[][]     array       = new int[][]{{0, -3, -8, 3}, {-9, 3, 5, 3}, {2, 3, -5, 3}};
        Solution308 solution308 = new Solution308(array);
        solution308.update(0, 1, 9);
        solution308.update(1, 0, -7);
        int sum = solution308.sumRegion(2, 2, 2, 3);
        System.out.println(sum);

    }
}
