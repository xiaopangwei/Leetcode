package leetcode.p2022m07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 3:27 PM
 */
public class Solution934 {
    Queue<int[]> queue      = new LinkedList<>();
    int[][]      directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {

        int         m       = grid.length;
        int         n       = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean     flag    = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(grid[i][j]+" "+i+" "+j);
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    grid[i][j] = 2;
                    visited[i][j] = true;
                    dfs(grid, i, j, visited);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        return bfs(grid);
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {

        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
                    || grid[newX][newY] == 0
                    || visited[newX][newY]) {
                continue;
            }
            visited[newX][newY] = true;
            grid[newX][newY] = 2;
            dfs(grid, newX, newY, visited);
            queue.add(new int[]{newX, newY});
//            System.out.println(newX + " " + newY);
        }


    }

    private int bfs(int[][] grid) {
        int     level = -1;
        boolean flag  = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int t = 0; t < size; t++) {
                int[] temp = queue.poll();
                for (int i = 0; i < directions.length; i++) {
                    int newX = temp[0] + directions[i][0];
                    int newY = temp[1] + directions[i][1];
                    if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                        continue;
                    }
                    if (grid[newX][newY] == 1) {
                        flag = true;
                        break;
                    }

                    if (grid[newX][newY] == 0) {
                        queue.add(new int[]{newX, newY});
                        grid[newX][newY] = 2;
                    }
                }
                if (flag) {
                    break;
                }
            }
            level++;
            if (flag) {
                break;
            }
        }
        return level;
    }

    public static void main(String[] args) {
        Solution934 solution934 = new Solution934();
        int         ans         = solution934.shortestBridge(new int[][]{{0,0,0,0,0,0},{0,1,0,0,0,0},{1,1,0,0,0,0},{1,1,0,0,0,0},{0,0,0,0,0,0},{0,0,1,1,0,0}});
        System.out.println(ans);
    }
}
