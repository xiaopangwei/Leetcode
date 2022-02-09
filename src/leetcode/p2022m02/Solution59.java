package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/8
 * @time 10:51 PM
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        dfs(matrix, n * n, 0, 0, 1);
        return matrix;
    }

    private void dfs(int[][] matrix, int len, int x, int y, int count) {

        System.out.println(x + " " + y);
        if (len == count) {
            matrix[x][y] = count;
            return;
        }
        if (len < count) {
            return;
        }
        int i = x;
        int j = y;
        //right
        while (j < matrix[0].length && matrix[i][j] == 0) {
            matrix[i][j++] = count++;
        }

        j--;
        i++;
        //down
        while (i < matrix.length && matrix[i][j] == 0) {
            matrix[i++][j] = count++;
        }

        i--;
        j--;
        //left
        while (j >= 0 && matrix[i][j] == 0) {
            matrix[i][j--] = count++;
        }

        //up
        j++;
        i--;

        while (i >= 0 && matrix[i][j] == 0) {
            matrix[i--][j] = count++;
        }

        i++;
        j++;
        dfs(matrix, len, i, j, count);

    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        int[][]    matrix     = solution59.generateMatrix(4);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
