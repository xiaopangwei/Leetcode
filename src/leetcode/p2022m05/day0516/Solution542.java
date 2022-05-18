package leetcode.p2022m05.day0516;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/16
 * @time 9:06 PM
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        boolean[][]  visited = new boolean[m][n];
        int[][]      ans     = new int[m][n];
        Queue<int[]> queue   = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int     level      = 1;
        while (!queue.isEmpty()) {
            int s = queue.size();
            for (int i = 0; i < s; i++) {
                int[] temp = queue.poll();
                for (int t = 0; t < 4; t++) {
                    int x = temp[0] + directions[t][0];
                    int y = temp[1] + directions[t][1];
                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        continue;
                    }
                    if (visited[x][y]) {
                        continue;
                    }
                    queue.add(new int[]{x,y});
                    visited[x][y] = true;
                    if (mat[x][y] == 1) {
                        ans[x][y] = level;
                    }
                }
            }
            level++;
        }

        return ans;
    }

    public static void main(String[] args) {
        //[[0,0,0],[0,1,0],[1,1,1]]
        Solution542 solution542 = new Solution542();
        int[][]     ans         = solution542.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
