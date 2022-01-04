package leetcode.p2021m12;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 11:23 AM
 */
public class Solution1091 {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}
            , {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) {
            return -1;
        }
        int         ans     = bfs(grid);
        return ans;
    }

    private boolean isValid(int x, int y, int m, int n) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        return true;
    }

    private int bfs(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (temp[0] == m - 1 && temp[1] == n - 1) {
                    return ans;
                }
                for (int[] arr : directions) {
                    int x = temp[0] + arr[0];
                    int y = temp[1] + arr[1];
                    if (isValid(x, y, m, n) && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Solution1091 solution1091 = new Solution1091();
        //{{0,0,0},{1,1,0},{1,1,0}}
        //{{1,0,0},{1,1,0},{1,1,0}}
        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,1},{1,0,0,0,0,0,0,0},{0,0,0,0,0,1,1,0},{0,0,1,0,1,0,1,1},{0,0,0,0,0,0,0,0},{0,0,0,1,1,1,0,0},{1,0,1,1,1,0,0,0}};
        int     ans  = solution1091.shortestPathBinaryMatrix(grid);
        System.out.println(ans);
    }
}
