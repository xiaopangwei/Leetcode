package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/19
 * @time 9:49 AM
 */
public class Solution887 {
    int[][] dp;

    public int superEggDrop(int k, int n) {

        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        //k,n
        dp = new int[k][n + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }

        for (int i = 0; i < k; i++) {
            dp[i][0] = 0;
        }

        int minStep = Integer.MAX_VALUE;
        //楼
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; k++) {
                //第i层碎了
                int a = get(j - 1, i - 1) + 1;
                //第i层没有碎
                int b = get(j, n - i) + 1;

                minStep = Math.min(minStep, Math.max(a, b));
            }

            set(k, n, minStep);
        }

        return -1;
    }

    // k层楼,n个鸡蛋

    private int get(int k, int n) {
        return dp[k - 1][n];
    }

    // k层楼,n个鸡蛋
    private void set(int k, int n, int val) {
        dp[k - 1][n] = val;
    }

    public static void main(String[] args) {
        Solution887 solution887 = new Solution887();
        System.out.println(solution887.superEggDrop(1, 2));
    }
}
