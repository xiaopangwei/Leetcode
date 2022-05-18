package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 11:36 PM
 */
public class Solution650 {
    int ans = Integer.MAX_VALUE;

    public int minSteps(int n) {
        dfs(n, 1, 0);
        return ans;
    }

    private int dfs(final int n, int current, int copyArea) {
        if (current > n) {
            return Integer.MAX_VALUE;
        }
        if (n == current) {
            return 0;
        }

        int t1 = Integer.MAX_VALUE;
        int t2 = Integer.MAX_VALUE;
        if (copyArea != current) {
            t1 = dfs(n, current, current);
        }
        if (copyArea > 0) {
            t2 = dfs(n, current + copyArea, copyArea);
        }

        int t = Math.min(t1, t2);
        if (t == Integer.MAX_VALUE) {
            return t;
        } else {
            return t + 1;
        }
    }

    public static void main(String[] args) {
        Solution650 solution650 = new Solution650();
        int         ans         = solution650.minSteps(100);
        System.out.println(ans);
    }
}
