package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/12
 * @time 2:06 PM
 */
public class Solution994 {
    static class BiKey {
        public int x;
        public int y;

        public BiKey(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BiKey biKey = (BiKey) o;

            if (x != biKey.x) return false;
            return y == biKey.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] finished       = new boolean[m][n];
        List<int[]> initialBadList = new ArrayList<>();
        Set<BiKey>  unFinished     = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    initialBadList.add(new int[]{i, j});
                    finished[i][j] = true;
                } else if (grid[i][j] == 0) {
                    finished[i][j] = true;
                } else {
                    unFinished.add(new BiKey(i, j));
                }
            }
        }


        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < initialBadList.size(); i++) {
            queue.add(initialBadList.get(i));
        }
        if (unFinished.isEmpty()) {
            return 0;
        }
        int count = 0;
        while (!queue.isEmpty()) {

            if (unFinished.isEmpty()) {
                break;
            }

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                int   x    = temp[0];
                int   y    = temp[1];
//                System.out.println(x + " " + y);
                BiKey key = new BiKey(x, y);
                if (unFinished.contains(key)) {
                    unFinished.remove(key);
                }
                finished[x][y] = true;
                grid[x][y] = 2;

                if (isValid(x + 1, y, m, n) && grid[x + 1][y] == 1 && !finished[x + 1][y]) {
                    queue.add(new int[]{x + 1, y});
                }
                if (isValid(x - 1, y, m, n) && grid[x - 1][y] == 1 && !finished[x - 1][y]) {
                    queue.add(new int[]{x - 1, y});
                }
                if (isValid(x, y + 1, m, n) && grid[x][y + 1] == 1 && !finished[x][y + 1]) {
                    queue.add(new int[]{x, y + 1});
                }
                if (isValid(x, y - 1, m, n) && grid[x][y - 1] == 1 && !finished[x][y - 1]) {
                    queue.add(new int[]{x, y - 1});
                }
            }

            System.out.println("------------BEGIN " + count);
            for (int i = 0; i < grid.length; i++) {
                System.out.println(Arrays.toString(grid[i]));
            }
            System.out.println("------------END " + count);

            count++;
        }

        if (!unFinished.isEmpty()) {
            return -1;
        } else {
            return count - 1;
        }
    }

    private boolean isValid(int x, int y, final int m, final int n) {

        if (x < 0 || y < 0 || x == m || y == n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution994 solution994 = new Solution994();
        int         ans         = solution994.orangesRotting(new int[][]{{2,2,1},{2,2,1},{2,2,1}});
//        int ans=solution994.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}});
        System.out.println(ans);
    }
}
