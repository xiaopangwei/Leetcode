package leetcode.p2021m08;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 9:58 AM
 */
public class Solution576 {
    static class Item {
        public int x;
        public int y;
        public int z;

        public Item(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Item item = (Item) o;

            if (x != item.x) return false;
            if (y != item.y) return false;
            return z == item.z;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }
    }

    long            maxValue   = 1000000007;
    int[][]         directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    Map<Item, Long> cache      = new HashMap<>();

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long res = dfs(m, n, maxMove, startRow, startColumn);
        return (int) (res % maxValue);
    }

    private long dfs(int m, int n, int maxMove, int startRow, int startColumn) {

        Item key = new Item(startRow, startColumn, maxMove);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (!isValid(m, n, startRow, startColumn)) {
            return 1;
        } else if (maxMove <= 0) {
            return 0;
        }

        long count = 0;
        for (int i = 0; i < 4; i++) {
            int newX = startRow + directions[i][0];
            int newY = startColumn + directions[i][1];
            count = (count + dfs(m, n, maxMove - 1, newX, newY)) % maxValue;
        }

        cache.put(key, count);
        return count;
    }

    private boolean isValid(int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution576 solution576 = new Solution576();
//        914783380
//        914783380

//        int         ans         = solution576.findPaths(2, 2, 2, 0, 0);

//        int         ans         = solution576.findPaths(1, 3, 3, 0, 1);
        int ans = solution576.findPaths(8, 50, 23, 5, 26);
        System.out.println(ans);
    }
}
