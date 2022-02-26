package leetcode.p2022m02;

import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 10:49 PM
 */
public class Solution139 {
    int[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return dfs(s, 0, wordDict);
    }

    private boolean dfs(String s, int startIndex, List<String> wordDict) {

        if (dp[startIndex] != -1) {
            if (dp[startIndex] == 1) {
                return true;
            }
            return false;
        }
        if (startIndex == s.length()) {
            dp[startIndex] = 1;
            return true;
        }

        for (int i = 1; i <= s.length(); i++) {
            int end = i + startIndex - 1;
            if (end >= s.length()) {
                break;
            }
            String sub = s.substring(startIndex, startIndex + i);
            if (!wordDict.contains(sub)) {
                continue;
            }
            if (dfs(s, end + 1, wordDict)) {
                dp[startIndex] = 1;
                return true;
            }
        }
        dp[startIndex] = 0;
        return false;
    }
}
