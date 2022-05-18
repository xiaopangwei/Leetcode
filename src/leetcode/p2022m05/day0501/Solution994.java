package leetcode.p2022m05.day0501;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 2:03 PM
 */
public class Solution994 {
    public int orangesRotting(int[][] grid) {
        int[][]     directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        List<int[]> rots       = new ArrayList<>();
        int         fresh      = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] ==1){
                    fresh++;
                } else if (grid[i][j] == 2) {
                    rots.add(new int[]{i,j});
                }
            }
        }
        Queue<int[]> queue   = new LinkedList<>();
        boolean[][]  visited = new boolean[grid.length][grid[0].length];
        for (int[] item : rots) {
            queue.add(item);
            visited[item[0]][item[1]] = true;
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (fresh<=0){
                break;
            }
            level++;
            for (int t = 0; t < size; t++) {
                int[] temp = queue.poll();
                System.out.println(temp[0]+" "+temp[1]);
                for (int i = 0; i < directions.length; i++) {
                    int newX = directions[i][0] + temp[0];
                    int newY = directions[i][1] + temp[1];
                    if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length) {
                        continue;
                    }
                    if (!visited[newX][newY] && grid[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                        fresh--;
                    }

                }
            }
        }

        if (fresh <= 0) {
            return level;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution994 solution994 = new Solution994();
        int         ans         = solution994.orangesRotting(new int[][]{{0,2}});
        System.out.println(ans);
    }
}
