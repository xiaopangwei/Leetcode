package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/23
 * @time 9:49 PM
 */
public class Solution188 {
    int k;
    Map<String, Integer> cached = new HashMap<>();

    public int maxProfit(int k, int[] prices) {
        this.k = k;
        return dfs(prices, 0, 0, false);
    }

    private int dfs(int[] prices, int index, int transactionTime, boolean flag) {
        String key = index + "#" + transactionTime + "#" + flag;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index == prices.length) {
            return 0;
        }
        if (transactionTime == this.k) {
            return 0;
        }

        int t1 = dfs(prices, index + 1, transactionTime, flag);
        int t2 = 0;
        if (!flag) {
            t2 = dfs(prices, index + 1, transactionTime, true) - prices[index];
        } else {
            t2 = dfs(prices, index + 1, transactionTime + 1, false) + prices[index];
        }
        int res = Math.max(t1, t2);
        cached.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        Solution188 solution188 = new Solution188();
        int         ans         = solution188.maxProfit(7, new int[]{48, 12, 60, 93, 97, 42, 25, 64, 17, 56, 85, 93, 9, 48, 52, 42, 58, 85, 81, 84, 69, 36, 1, 54, 23, 15, 72, 15, 11, 94});
        System.out.println(ans);
    }
}
