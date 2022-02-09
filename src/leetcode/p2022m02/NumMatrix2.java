package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/8
 * @time 9:39 PM
 */
public class NumMatrix2 {
    int[][] prefixSumArray;

    private int get(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        return prefixSumArray[i][j];
    }

    public NumMatrix2(int[][] matrix) {
        int cols = matrix[0].length;
        int rows = matrix.length;

        prefixSumArray = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                prefixSumArray[i][j] = get(i - 1, j) + get(i, j - 1) - get(i - 1, j - 1) + matrix[i][j];
            }
        }

        for (int i=0;i<rows;i++){
            System.out.println(Arrays.toString(prefixSumArray[i]));
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return get(row2, col2) - get(row1-1, col2) - get(row2, col1-1) + get(row1-1, col1-1);
    }

    public static void main(String[] args) {
        int[][]    array   = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix2 matrix2 = new NumMatrix2(array);
        int        s       = matrix2.sumRegion(1, 2, 2, 4);
        System.out.println(s);
    }
}
