package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 10:42 PM
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {


        if (s == null || p == null) {
            if (s==null && p==null){
                return true;
            }else {
                return false;
            }
        }
        int srcLen     = s.length();
        int patternLen = p.length();

        boolean[][] dp = new boolean[patternLen + 1][srcLen + 1];
        dp[0][0] = true;
        if (patternLen == 0) {
            if (srcLen==0){
                return true;
            }else{
                return false;
            }
        }

        int prefixStarCount = 0;
        for (int i = 0; i < patternLen; i++) {
            if (p.charAt(i) == '*') {
                prefixStarCount++;
            } else {
                break;
            }
        }

        for (int i = 0; i < prefixStarCount; i++) {
                for (int j = 0; j < srcLen + 1; j++)
                { dp[i + 1][j] = true;}
        }


        for (int i = prefixStarCount; i < patternLen; i++) {
            if (p.charAt(i) == '*') {
                for (int j = 0; j < srcLen+1; j++) {
                    if (dp[i][j]) {
                        for (int k = j; k < srcLen+1; k++) {
                            dp[i+1][k] = true;
                        }
                    }
                }
            } else if (p.charAt(i) == '?') {
                for (int j = 0; j < srcLen; j++) {
                    if (dp[i][j]) {
                        dp[i+1][j+1] = true;
                    }
                }

            } else {
                for (int j = 0; j < srcLen ; j++) {
                    if (dp[i][j] && p.charAt(i) == s.charAt(j)) {
                        dp[i+1][j+1] = true;
                    }
                }
            }
        }
        for (int i=0;i<patternLen+1;i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[patternLen][srcLen];
    }

    public static void main(String[] args){
        Solution44 solution44=new Solution44();

        boolean ans=solution44.isMatch("abcabczzzde","*abc???de*");


        System.out.println(ans);
    }
}
