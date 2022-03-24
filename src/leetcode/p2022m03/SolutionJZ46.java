package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/3
 * @time 9:42 PM
 */
public class SolutionJZ46 {
    int[] dp;

    public int translateNum(int num) {

        char[] array = String.valueOf(num).toCharArray();
        dp = new int[array.length];
        Arrays.fill(dp, -1);
        return dfs(array, 0);

    }

    private int dfs(char[] array, int start) {
        if (start >= array.length) {
            return 1;
        }

        if (dp[start] != -1) {
            return dp[start];
        }

        int ans = 0;
        ans += dfs(array, start + 1);
        if (start + 1 < array.length &&
                (array[start] == '1' || (array[start] == '2' && array[start + 1] <= '5'))) {
            ans += dfs(array, start + 2);
        }
        dp[start] = ans;
        return ans;
    }

    public static void main(String[] args) {
        SolutionJZ46 solutionJZ46 = new SolutionJZ46();
        int          ans          = solutionJZ46.translateNum(12258);
        System.out.println(ans);
    }
}
