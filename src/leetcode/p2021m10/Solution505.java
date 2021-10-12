package leetcode.p2021m10;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/8
 * @time 8:28 PM
 */
public class Solution505 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    int[][] distance;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < distance.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        distance[start[0]][start[1]] = 0;


        while (!queue.isEmpty()) {

            int[] prev = queue.poll();
            int   x    = prev[0];
            int   y    = prev[1];

            int         prevDist   = distance[x][y];
            getCandidates(maze, new int[]{x, y}, prevDist, queue);

        }

        int dist=distance[destination[0]][destination[1]];
        return dist==Integer.MAX_VALUE?-1:dist;
    }


    private void getCandidates(int[][] maze, int[] current,
                                      int prevStep, Queue<int[]> queue) {



        for (int i = 0; i < directions.length; i++) {
            int     x    = current[0];
            int     y    = current[1];
            boolean flag = false;
            int     temp = 0;
            while (isValid(x + directions[i][0],
                    y + directions[i][1], maze) &&
                    maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                x += directions[i][0];
                y += directions[i][1];
                temp++;
                flag = true;
            }
            if (flag) {
                if (isValid(x, y, maze)) {

                    int newStep = prevStep + temp;
                    if (newStep <= distance[x][y]) {
                        distance[x][y] = newStep;
                        int[] t = new int[]{x, y};

                        queue.add(t);
                    }
                }
            }

        }

    }

    private boolean isValid(int x, int y, int[][] maze) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution505 solution505 = new Solution505();
        int ans = solution505.shortestDistance(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}
                , new int[]{0, 4}, new int[]{4, 4});
        System.out.println(ans);
    }
}
