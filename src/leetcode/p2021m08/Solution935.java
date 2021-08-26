package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/24
 * @time 10:51 PM
 */
public class Solution935 {
    int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};

    Map<BiKey, Long> cache      = new HashMap<>();
    int[][]          directions = new int[][]{{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

    static final long MOD = 1000000000 + 7;

    public int knightDialer(int n) {
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] != -1) {
                    ans += dfs(i, j, n - 1);
                }
            }
        }
        return (int) (ans % MOD);
    }

    static class BiKey {
        public int x;
        public int y;
        public int step;

        public BiKey(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BiKey biKey = (BiKey) o;

            if (x != biKey.x) return false;
            if (y != biKey.y) return false;
            return step == biKey.step;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + step;
            return result;
        }
    }

    private long dfs(int x, int y, int step) {
        BiKey key = new BiKey(x, y, step);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (step == 0) {
            return 1;
        }

        long temp = 0;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isValid(newX, newY) && grid[newX][newY] != -1) {
                temp = (temp + dfs(newX, newY, step - 1)) % MOD;
            }
        }

        cache.put(key, temp);
        return temp;

    }

    private boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 4 || y >= 3) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution935 solution935 = new Solution935();
        System.out.println(solution935.knightDialer(400));
    }
}
