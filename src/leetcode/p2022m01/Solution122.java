package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/20
 * @time 10:55 PM
 */
public class Solution122 {
    Map<String, Integer> cached = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, 0, true);
    }


    private int dfs(int[] prices, int index, int transactionTime, boolean direction) {
        String key = index + "#" + transactionTime + "#" + direction;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index == prices.length || transactionTime == 2) {
            return 0;
        }
        int t = dfs(prices, index + 1, transactionTime, direction);
        if (direction) {
            t = Math.max(t, dfs(prices, index + 1, transactionTime, false) - prices[index]);
        } else {
            t = Math.max(t, dfs(prices, index + 1, transactionTime + 1, true) + prices[index]);
        }

        cached.put(key, t);
        return t;

    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int         ans         = solution122.maxProfit(new int[]{7, 6, 4, 3, 1});
        System.out.println(ans);
    }
}
