package leetcode.p2022m05.day0507;

import leetcode.p2021m06.p20210629.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 11:04 PM
 */
public class Solution131 {

    int[][] dp;
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {

        dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        dfs(s, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(String s, int startIndex, List<String> selected) {
        if (startIndex == s.length()) {
            List<String> temp = new ArrayList<>();
            temp.addAll(selected);
            ans.add(temp);
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            int end = startIndex + i - 1;
            if (end >= s.length()) {
                continue;
            }
            String temp = s.substring(startIndex, end + 1);
            if (!isPalindrome(s, startIndex, end)) {
                continue;
            }
            selected.add(temp);
            dfs(s, end + 1, selected);
            selected.remove(selected.size() - 1);

        }
    }


    private boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return true;
        }
        if (dp[start][end] != -1) {
            return dp[start][end] != 0;
        }

        if (start == end) {
            dp[start][end] = 1;
            return true;
        }

        boolean ans = s.charAt(start) == s.charAt(end) && isPalindrome(s, start + 1, end - 1);
        if (ans) {
            dp[start][end] = 1;
        } else {
            dp[start][end] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution131 solution131 = new Solution131();
//        System.out.println(solution131.isPalindrome("aab",0,1));
        System.out.println(solution131.partition("a"));
    }
}
