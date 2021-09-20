package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 1:47 PM
 */
public class Solution562 {
    public int longestLine(int[][] mat) {
        //水平

        int     ans        = 0;
        int     m          = mat.length;
        int     n          = mat[0].length;
        int[][] horizontal = new int[m][n];
        int[][] vertical   = new int[m][n];
        int[][] diag       = new int[m][n];
        int[][] antiDiag   = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int val = mat[i][j];
                if (j >= 1) {
                    if (val == 1) {
                        horizontal[i][j] = horizontal[i][j - 1] + 1;
                    } else {
                        horizontal[i][j] = 0;
                    }
                } else {
                    horizontal[i][j] = mat[i][j];
                }

                if (i >= 1) {
                    if (val == 1) {
                        vertical[i][j] = vertical[i - 1][j] + 1;
                    } else {
                        vertical[i][j] = 0;
                    }
                } else {
                    vertical[i][j] = mat[i][j];
                }

                if (i >= 1 && j >= 1) {
                    if (val == 1) {
                        diag[i][j] = diag[i - 1][j - 1] + 1;
                    } else {
                        diag[i][j] = 0;
                    }
                } else {
                    diag[i][j] = mat[i][j];
                }


                int sum      = i + j;
                int rowIndex = i - 1;
                int colIndex = sum - rowIndex;

                if (rowIndex >= 0 && colIndex >= 0 && rowIndex < m && colIndex < n) {
                    if (val == 1) {
                        antiDiag[i][j] = antiDiag[rowIndex][colIndex] + 1;
                    } else {
                        antiDiag[i][j] = 0;
                    }
                } else {
                    antiDiag[i][j] = mat[i][j];
                }

                ans = Math.max(ans, horizontal[i][j]);
                ans = Math.max(ans, vertical[i][j]);
                ans = Math.max(ans, diag[i][j]);
                ans = Math.max(ans, antiDiag[i][j]);
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        Solution562 solution562 = new Solution562();
        int[][]     array       = new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}};
        int         ans         = solution562.longestLine(array);
        System.out.println(ans);
    }
}
