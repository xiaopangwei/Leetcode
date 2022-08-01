package leetcode.p2022m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 10:28 PM
 */
public class Solution1254 {
    int     cnt        = 0;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


    void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

        System.out.println("-----------------------");
    }

    public int closedIsland(int[][] grid) {


        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
        }
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, grid[0].length - 1);
        }

        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, 0, i);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, grid.length - 1, i);
        }

        print(grid);

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    search(grid, i, j);
                    print(grid);
                    cnt++;
                }
            }

        }


        return cnt;

    }

    private void dfs(int[][] grid, int x, int y) {

        if (grid[x][y] != 0) {
            return;
        }
        if (grid[x][y] == 0) {
            grid[x][y] = 1;
        }
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                continue;
            }

            if (grid[newX][newY] != 0) {
                continue;
            }

            dfs(grid, newX, newY);
        }
    }


    private void search(int[][] grid, int x, int y) {
        grid[x][y] = 1;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                continue;
            }
            if (grid[newX][newY] == 0) {
                dfs(grid, newX, newY);
            }
        }
    }


    public static void main(String[] args) {
        int[][]      array        = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        Solution1254 solution1254 = new Solution1254();
        int          ans          = solution1254.closedIsland(array);
        System.out.println(ans);

    }
}
