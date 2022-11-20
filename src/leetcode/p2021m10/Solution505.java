package leetcode.p2021m10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
            for (int i = 0; i < directions.length; i++) {
                int newX  = prev[0] + directions[i][0];
                int newY  = prev[1] + directions[i][1];
                int count = 0;
                while (isValid(newX, newY, maze) && maze[newX][newY]==0) {
                    newX += directions[i][0];
                    newY += directions[i][1];
                    count++;
                }

                newX -= directions[i][0];
                newY -= directions[i][1];
                if (distance[newX][newY] > distance[prev[0]][prev[1]] + count) {
                    distance[newX][newY] = distance[prev[0]][prev[1]] + count;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
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
