package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/14
 * @time 9:30 PM
 */
public class Solution329 {

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int[][] cached;

    public int longestIncreasingPath(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        cached  = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < cached.length; i++) {
            Arrays.fill(cached[i], -1);
        }
        int maxVal = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    maxVal = Math.max(dfs(matrix, visited, matrix[i][j], i, j), maxVal);
                    visited[i][j] = false;
                }
            }
        }
        return maxVal;
    }

    private int dfs(int[][] matrix, boolean[][] visited, int currentMax, int x, int y) {
        int ans = 0;
        if (this.cached[x][y] != -1) {
            return this.cached[x][y];
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = directions[i][0] + x;
            int newY = directions[i][1] + y;
            if (newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length
                    || visited[newX][newY]
                    || matrix[newX][newY] <= currentMax) {
                continue;
            }

            visited[newX][newY] = true;
            ans = Math.max(dfs(matrix, visited, matrix[newX][newY], newX, newY), ans);
            visited[newX][newY] = false;
        }
        cached[x][y] = ans + 1;
        return ans + 1;
    }

    public static void main(String[] args) {
        int[][]     array       = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};
        Solution329 solution329 = new Solution329();
        int         max         = solution329.longestIncreasingPath(array);
        System.out.println(max);
    }
}
