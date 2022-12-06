package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/3
 * @time 4:16 PM
 */
public class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max_ans = 1;
        for (int i = 1; i < n; i++) {
            int before = dp[i - 1];
            int cnt    = 1;
            for (int j = i - 1; j >= i - before; j--) {
                if ((nums[i] & nums[j]) == 0)
                {cnt++;}
            }
            dp[i] = Math.max(cnt, dp[i]);
            max_ans = Math.max(max_ans, dp[i]);
        }
        return max_ans;
    }

    public static void main(String[] args) {
        Solution2401 solution2401 = new Solution2401();
        int          ans          = solution2401.longestNiceSubarray(new int[]{744437702, 379056602, 145555074, 392756761, 560864007, 934981918, 113312475, 1090, 16384, 33, 217313281, 117883195, 978927664});
        System.out.println(ans);
    }
}
