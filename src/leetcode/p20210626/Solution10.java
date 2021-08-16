package leetcode.p20210626;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 5:21 PM
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            if (s == null && p == null) {
                return true;
            }
            return false;
        }
        if (s.length()==0 && p.length()==0){
            return true;
        }else if (s.length()>0 && p.length()==0){
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

//        System.out.println(s + " " + p);

        //c*a*b
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                dp[0][i + 1] = dp[0][i - 1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //a-z
//                System.out.println(i + " " + j);
                if (p.charAt(j) >= 'a' && p.charAt(j) <= 'z') {
                    if (p.charAt(j) == s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                } else if (p.charAt(j) == '*') {
                    if (j > 0) {
                        if (p.charAt(j - 1) == s.charAt(i)) {
                            dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1];
                        } else if (p.charAt(j - 1) == '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i][j + 1];
                        } else {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        }
                    }
                } else {
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }


        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[s.length()][p.length()];
    }
//
//    "aaa"
//    "ab*a*c*a"
    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();
        boolean    ans        = solution10.isMatch("aaa", "ab*a*c*a");
        System.out.println(ans);
    }
}
