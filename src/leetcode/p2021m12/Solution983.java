package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/21
 * @time 9:37 PM
 */
public class Solution983 {
    Map<Integer, Integer> cached = new HashMap<>();

    public int mincostTickets(int[] days, int[] costs) {

        Map<Integer, Integer> map = new HashMap<>();


        for (int i = 1; i < days[0]; i++) {
            map.put(i, days[0]);
        }
        for (int i = 0; i < days.length - 1; i++) {

            for (int j = days[i] + 1; j < days[i + 1]; j++) {
                map.put(j, days[i + 1]);
            }
        }

        for (int i = days[days.length - 1] + 1; i <= 365; i++) {
            map.put(i, 366);
        }


        for (int day : days) {
            map.put(day, day);
        }

        return dfs(1, map, costs);
    }

    private int dfs(int index, final Map<Integer, Integer> map, int[] costs) {

        if (cached.containsKey(index)) {
            return cached.get(index);
        }
        if (index > 365) {
            return 0;
        }

        int t = map.get(index);
        if (t != index) {
            int next = map.get(index);
            int temp = dfs(next, map, costs);
            cached.put(index, temp);
            return temp;
        } else {
            int minValue = Integer.MAX_VALUE;
            minValue = Math.min(minValue, dfs(index + 1, map, costs) + costs[0]);
            minValue = Math.min(minValue, dfs(index + 7, map, costs) + costs[1]);
            minValue = Math.min(minValue, dfs(index + 30, map, costs) + costs[2]);
            cached.put(index, minValue);
            return minValue;
        }

    }

    public static void main(String[] args) {
        Solution983 solution983 = new Solution983();
        int         ans         = solution983.mincostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[]{2, 7, 15});
        System.out.println(ans);
    }
}
