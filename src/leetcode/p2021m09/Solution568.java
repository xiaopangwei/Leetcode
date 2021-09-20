package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 4:34 PM
 */
public class Solution568 {
    public int[][] flights;
    public int[][] days;

    public Map<String, Integer> cached = new HashMap<>();

    public int maxVacationDays(int[][] flights, int[][] days) {
        this.flights = flights;
        this.days = days;

        return dfs(0, 0, days.length, flights.length);
    }

    private int dfs(int siteIndex, int dayIndex, final int maxDays, int m) {

        String key = siteIndex + "#" + dayIndex;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (dayIndex == maxDays) {
            return 0;
        }
        int maxVal = 0;

        for (int i = 0; i < m; i++) {
            if (flights[siteIndex][i] == 1 || i == siteIndex) {
                maxVal = Math.max(maxVal, days[i][dayIndex] + dfs(i, dayIndex + 1, maxDays, m));
            }
        }
        cached.put(key, maxVal);
        return maxVal;
    }

    public static void main(String[] args) {
        Solution568 solution568 = new Solution568();
        int[][]     flights     = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};

        int[][] days = new int[][]{{1, 3, 1}, {6, 0, 3}, {3, 3, 3}};
        int     ans  = solution568.maxVacationDays(flights, days);
        System.out.println(ans);

    }
}
