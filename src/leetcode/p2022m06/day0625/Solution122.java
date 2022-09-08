package leetcode.p2022m06.day0625;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/25
 * @time 10:36 PM
 */
public class Solution122 {
    Map<String, Integer> cached = new HashMap<>();

    int fee;

    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        return dfs(prices,0,false);
    }

    private int dfs(int[] prices, int index, boolean position) {
        String biKey = index + "#" + position;
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (index >= prices.length) {
            return 0;
        }
        int ans = dfs(prices, index + 1, position);
        if (position) {
            ans = Math.max(ans, prices[index] + dfs(prices, index + 2, false) - fee);
        } else {
            ans = Math.max(ans, -prices[index] + dfs(prices, index + 1, true));
        }
        cached.put(biKey, ans);
        return ans;
    }
}
