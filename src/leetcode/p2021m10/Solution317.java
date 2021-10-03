package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 9:38 AM
 */
public class Solution317 {

    static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public int shortestDistance(int[][] grid) {

        int         m        = grid.length;
        int         n        = grid[0].length;
        int[][]     distance = new int[m][n];
        boolean[][] visited  = new boolean[m][n];
        List<int[]> list     = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for (int a = 0; a < list.size(); a++) {
            int          i     = list.get(a)[0];
            int          j     = list.get(a)[1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j, 0});
            for (int t = 0; t < m; t++) {
                Arrays.fill(visited[t], false);
            }
            visited[i][j] = true;
            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int newX = tuple[0] + DIRECTIONS[k][0];
                    int newY = tuple[1] + DIRECTIONS[k][1];

                    if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                        continue;
                    }

                    if (grid[newX][newY] != 0 || visited[newX][newY] || distance[newX][newY] < 0) {
                        continue;
                    }

                    visited[newX][newY] = true;
                    int temp = tuple[2] + 1;
                    distance[newX][newY] += temp;
                    queue.add(new int[]{newX, newY, temp});

                }
            }

            for (int r = 0; r < m; r++) {
                for (int col = 0; col < n; col++) {
                    if (grid[r][col] == 0 && !visited[r][col]) {
                        distance[r][col] = -1;
                    }
                }
            }
        }


        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && distance[i][j] != -1) {

                    minDist = Math.min(minDist, distance[i][j]);
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            return -1;
        }
        return minDist;
    }

    public static void main(String[] args) {
        Solution317 solution317 = new Solution317();
        int         ans         = solution317.shortestDistance(new int[][]{{1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1}, {0, 1, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 1}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {0, 1, 1, 1, 1, 0}});
        System.out.println(ans);
    }

}
