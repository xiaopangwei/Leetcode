package leetcode.p2021m09;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/16
 * @time 9:08 PM
 */
public class Solution286 {
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        int          m       = rooms.length;
        int          n       = rooms[0].length;
        boolean[][]  visited = new boolean[m][n];
        Queue<int[]> queue   = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }
        bfs(rooms, queue, visited);
    }

    private void bfs(int[][] room, Queue<int[]> queue, boolean[][] visited) {

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            room[temp[0]][temp[1]] = temp[2];
            for (int i = 0; i < directions.length; i++) {
                int newX = directions[i][0] + temp[0];
                int newY = directions[i][1] + temp[1];
                if (isValid(newX, newY, room.length, room[0].length)
                        && room[newX][newY] > 0
                        && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, temp[2] + 1});
                }
            }
        }

        for (int i = 0; i < room.length; i++) {
            System.out.println(Arrays.toString(room[i]));
        }
    }

    private boolean isValid(int x, int y, int len1, int len2) {
        if (x < 0 || y < 0 || x >= len1 || y >= len2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution286 solution286 = new Solution286();
        solution286.wallsAndGates(new int[][]{{2147483647, -1, 0, 2147483647}, {2147483647, 2147483647, 2147483647, -1}, {2147483647, -1, 2147483647, -1}, {0, -1, 2147483647, 2147483647}});
    }
}
