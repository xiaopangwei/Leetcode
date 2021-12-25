package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 4:57 PM
 */
public class Solution714 {
    Map<String, Integer> cached = new HashMap<>();

    public int maxProfit(int[] prices, int fee) {
        return dfs(prices, fee, 0, false);
    }

    private int dfs(int[] prices, int fee, int index, boolean flag) {
        String key = index + "#" + flag;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index >= prices.length) {
            return 0;
        }
        int ans = 0;
        //不做
        int t1 = dfs(prices, fee, index + 1, flag);

        ans = Math.max(ans, t1);
        if (!flag) {
            //买
            int t2 = -prices[index] + dfs(prices, fee, index + 1, true);
            ans = Math.max(ans, t2);
        } else {
            //卖
            int t3 = prices[index] + dfs(prices, fee, index + 1, false) - fee;
            ans = Math.max(ans, t3);
        }

        cached.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution714 solution714 = new Solution714();
        int         ans         = solution714.maxProfit(new int[]{1, 3, 7, 5, 10, 3}, 3);
        System.out.println(ans);
    }
}
