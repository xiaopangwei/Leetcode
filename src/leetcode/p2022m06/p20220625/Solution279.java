package leetcode.p2022m06.p20220625;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/26
 * @time 8:24 PM
 */
public class Solution279 {

    public int numSquares(int n) {
        return dfs(n, 0);
    }

    private int dfs(final int n, int currentSum) {

        if (currentSum > n) {
            return Integer.MAX_VALUE;
        }
        if (currentSum == n) {
            return 0;
        }
        int t   = (int) Math.sqrt(n);
        int ans = n;
        for (int i = 1; i <= t; i++) {
            int s     = i * i;
            int times = dfs(n, currentSum + s);
            if (times != Integer.MAX_VALUE) {
                ans = Math.min(times + 1, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution279 solution279 = new Solution279();
        int         n           = solution279.numSquares(13);
        System.out.println(n);
    }
}
