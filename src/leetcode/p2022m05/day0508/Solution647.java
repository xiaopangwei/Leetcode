package leetcode.p2022m05.day0508;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 7:30 PM
 */
public class Solution647 {
    int[][] cached;

    public int countSubstrings(String s) {
        cached = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            Arrays.fill(cached[i], -1);
        }

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                ans += dfs(s, i, j);
            }
        }
        return ans;
    }


    private int dfs(String s, int start, int end) {
        if (start >= end) {
            return 1;
        }

        if (cached[start][end] != -1) {
            return cached[start][end];
        }

        if (start + 1 == end) {
            if (s.charAt(start) == s.charAt(end)) {
                return 1;
            } else {
                return 0;
            }
        }

        int ans = 0;
        if (s.charAt(start) == s.charAt(end)) {
            ans = dfs(s, start + 1, end - 1);
        }

        cached[start][end] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution647 solution647 = new Solution647();
        int         ans         = solution647.countSubstrings("aaa");
        System.out.println(ans);
    }
}
