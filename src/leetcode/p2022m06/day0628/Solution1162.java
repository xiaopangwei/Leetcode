package leetcode.p2022m06.day0628;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/5
 * @time 10:51 PM
 */
public class Solution1162 {
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int maxDistance(int[][] grid) {

        int maxVal = -1;
//        int ans=bfs(grid,2,2);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    maxVal = Math.max(maxVal, bfs(grid, i, j));
                }
            }
        }
        return maxVal;
    }

    private int bfs(int[][] grid, int x, int y) {
        Queue<int[]> queue   = new LinkedList<>();
        boolean[][]  visited = new boolean[grid.length][grid[0].length];
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                if (grid[temp[0]][temp[1]] == 1) {
                    return level;
                }
                for (int t = 0; t < directions.length; t++) {
                    int newX = directions[t][0] + temp[0];
                    int newY = directions[t][1] + temp[1];
                    if (isValid(newX, newY, grid) && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                    }
                }

            }
            level++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix=new int[][]{{1,0,0},{0,0,0},{0,0,0}};
        Solution1162 solution1162=new Solution1162();
        int ans=solution1162.maxDistance(matrix);
        System.out.println(ans);
    }
}
