package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/22
 * @time 10:24 PM
 */
public class Solution343 {
    Map<Integer, Integer> cached = new HashMap<>();

    public int integerBreak(int n) {

        int ans = dfs(n);

        return ans;
    }


    private int dfs(int n) {
        if (cached.containsKey(n)) {
            return cached.get(n);
        }
        if (n == 1) {
            return 1;
        }

        int maxVal = 0;
        for (int i = 1; i < n; i++) {
            maxVal = Math.max(maxVal, i * (n - i));
            maxVal = Math.max(maxVal, i * dfs(n - i));
        }
        cached.put(n, maxVal);
        return maxVal;
    }

    public static void main(String[] args) {
        Solution343 solution343 = new Solution343();
        int         ans         = solution343.integerBreak(10);
        System.out.println(ans);
    }
}
