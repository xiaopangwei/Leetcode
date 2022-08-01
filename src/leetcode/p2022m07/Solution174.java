package leetcode.p2022m07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/30
 * @time 9:58 AM
 */
public class Solution174 {
    int[][] directions = new int[][]{{1, 0}, {0, 1}};
    int[][] dungeon;
    Map<String, Integer> cached = new HashMap<>();

    public int calculateMinimumHP(int[][] dungeon) {
        this.dungeon = dungeon;
        int maxVal = dfs(0, 0, 0, 0);
        if (maxVal > 0) {
            return 0;
        } else {
            return 1 - maxVal;
        }
    }

    private int dfs(int x, int y, int minVal, int sum) {
        String biKey = x + "#" + y + "#" + minVal;
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (x == dungeon.length - 1 && y == dungeon[0].length - 1) {
            minVal = Math.min(minVal, dungeon[x][y] + sum);
            cached.put(biKey, minVal);
            return minVal;
        }
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= dungeon.length || newY >= dungeon[0].length) {
                continue;
            }
            minVal = Math.min(minVal, sum + dungeon[x][y]);
            maxVal = Math.max(maxVal, dfs(newX, newY, minVal, sum + dungeon[x][y]));

        }
        cached.put(biKey, maxVal);
        return maxVal;
    }

    public static void main(String[] args) {
        Solution174 solution174 = new Solution174();
        int[][]     dungeon     = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int         ans         = solution174.calculateMinimumHP(dungeon);
        System.out.println(ans);
    }
}
