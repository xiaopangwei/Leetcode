package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/7
 * @time 9:16 PM
 */
public class SolutionJZOffer29 {
    int[][]     matrix;
    boolean[][] visited;

    public int[] spiralOrder(int[][] matrix) {
        this.matrix = matrix;
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.visited = new boolean[rows][cols];
        int[] ans = new int[rows * cols];
        dfs(0, 0, 0, rows * cols,ans);
        return ans;
    }

    private void dfs(int x, int y, int index, int maxCount, int[] ans) {
        if (maxCount == index) {
            return;
        }
        int x1 = x;
        int y1 = y;
        while (y1 < matrix[0].length && !visited[x1][y1]) {
            ans[index++] = matrix[x1][y1];
            visited[x1][y1] = true;
            y1++;
        }

        y1--;
        x1++;


        while (x1 < matrix.length && !visited[x1][y1]) {
            ans[index++] = matrix[x1][y1];
            visited[x1][y1] = true;
            x1++;
        }

        x1--;
        y1--;


        while (y1 >= 0 && !visited[x1][y1]) {
            ans[index++] = matrix[x1][y1];
            visited[x1][y1] = true;
            y1--;
        }


        y1++;
        x1--;


        while (x1 >= 0 && !visited[x1][y1]) {
            ans[index++] = matrix[x1][y1];
            visited[x1][y1] = true;
            x1--;
        }


        dfs(x1 + 1, y1 + 1, index, maxCount, ans);
    }

    public static void main(String[] args) {
        SolutionJZOffer29 solutionJZ29 = new SolutionJZOffer29();
        int[]             ans          = solutionJZ29.spiralOrder(new int[][]{{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}});
        System.out.println(Arrays.toString(ans));
    }
}
