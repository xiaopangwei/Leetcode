package leetcode.springfestival.sf20220130;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 3:46 PM
 */
public class Solution5 {
    int maxVal = 0;
    int start  = 0;
    int end    = 0;
    int[][] dp;

    public String longestPalindrome1(String s) {

        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < s.length(); i++) {
            for (int t = 1; t <= s.length(); t++) {
                int j = i + t - 1;
                if (j >= s.length() || j < 0) {
                    continue;
                }

                dp[i][j] = dfs(s, i, j);
//                System.out.println(i+" "+j+" "+dp[i][j]);
                if (dp[i][j] == 1 && t > maxVal) {
                    start = i;
                    end = j;
                    maxVal = t;
//                    System.out.println("max"+maxVal);
                }
            }
        }
        return s.substring(start, end + 1);
    }

    private int dfs(String s, int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start > end) {
            dp[start][end] = 1;
            return 1;
        }
        if (start == end) {
            dp[start][end] = 1;
            return 1;
        }
        if (start + 1 == end && s.charAt(start) == s.charAt(end)) {
            dp[start][end] = 1;
            return 1;
        }

        char left  = s.charAt(start);
        char right = s.charAt(end);

        int ans = 0;
        if (left == right) {
            ans = dfs(s, start + 1, end - 1);
        }
        dp[start][end] = ans;
        return ans;

    }

    public String longestPalindrome2(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            int middle = i;
            int idx1   = middle - 1;
            int idx2   = middle + 1;
            while (true) {
                if (idx1 < 0 || idx2 >= s.length()) {
                    break;
                }
                if (s.charAt(idx1) == s.charAt(idx2)) {
                    idx1--;
                    idx2++;
                } else {
                    break;
                }
            }

            int length = idx2 - idx1 - 1;
            if (length > maxVal) {
                maxVal = length;
                start = idx1 + 1;
                end = idx2 - 1;
            }


            int m1 = i;
            int m2 = i + 1;

            if (s.charAt(m1) == s.charAt(m2)) {
                idx1 = m1 - 1;
                idx2 = m2 + 1;
                while (true) {
                    if (idx1 < 0 || idx2 < 0 || idx1 >= s.length() || idx2 >= s.length()) {
                        break;
                    }
                    if (s.charAt(idx1) == s.charAt(idx2)) {
                        idx1--;
                        idx2++;
                    } else {
                        break;
                    }
                }
                length = idx2 - idx1 - 1;
                if (length > maxVal) {
                    maxVal = length;
                    start = idx1 + 1;
                    end = idx2 - 1;
                }

            }


        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String    ans       = solution5.longestPalindrome2("cbbd");
        System.out.println(ans);
    }
}
