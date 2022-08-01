package leetcode.p2022m07;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/20
 * @time 10:01 PM
 */
public class Solution1162 {
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    Queue<int[]> queue = new LinkedList<>();

    public int maxDistance(int[][] grid) {
        int         m       = grid.length;
        int         n       = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }

        int dist = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int   x    = temp[0];
                int   y    = temp[1];

                for (int t = 0; t < 4; t++) {
                    int newX = x + directions[t][0];
                    int newY = y + directions[t][1];
                    if (newX < 0 || newY < 0 ||
                            newX >= grid.length || newY >= grid[0].length ||
                            visited[newX][newY] || grid[newX][newY] == 1) {
                        continue;
                    }
                    queue.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
            dist++;
        }
        return dist;
    }


}
