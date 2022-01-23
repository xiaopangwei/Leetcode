package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/23
 * @time 10:03 PM
 */
public class Solution714 {
    Map<String, Integer> cached = new HashMap<>();
    int fee;

    public int maxProfit(int[] prices, int fee) {
        this.fee = fee;
        return dfs(prices, 0, false);
    }

    private int dfs(int[] prices, int index, boolean position) {
        String key = index + "#" + position;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index >= prices.length) {
            return 0;
        }

        int t1 = dfs(prices, index + 1, position);
        int t2 = 0;
        if (position) {
            t2 = prices[index] + dfs(prices, index + 1, false) - fee;
        } else {
            t2 = -prices[index] + dfs(prices, index + 1, true);
        }
        int ans = Math.max(t1, t2);
        cached.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
        int         ans         = solution714.maxProfit(new int[]{1,3,7,5,10,3}, 3);
        System.out.println(ans);
    }
}
