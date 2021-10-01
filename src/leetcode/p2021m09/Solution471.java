package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/30
 * @time 11:03 PM
 */
public class Solution471 {
    public String encode(String s) {

        int        len = s.length();
        String[][] dp  = new String[len][len];

        for (int k = 1; k <= len; k++) {
            for (int i = 0; i < len; i++) {
                int j = i + k - 1;
                if (j >= len) {
                    continue;
                }
                if (k <= 4) {
                    dp[i][j] = s.substring(i, j + 1);
                } else {

                    dp[i][j] = abbr(s, i, j, dp);
                    for (int m = i; m < j; m++) {

                        String compose = dp[i][m] + dp[m + 1][j];
                        if (compose.length() < dp[i][j].length()) {
                            dp[i][j] = compose;
                        }
                    }
                }

            }
        }
        return dp[0][len - 1];
    }


    private String abbr(String s, int i, int j, String[][] dp) {
        String sub   = s.substring(i, j + 1);
        String temp  = sub + sub;
        int    index = temp.indexOf(sub, 1);
        if (index != sub.length()) {
            int    cnt = sub.length() / index;
            String ans = cnt + "[" + dp[i][i + index - 1] + "]";
//            System.out.println(sub + "==>" + ans);
            return ans;
        } else {

            return sub;
        }

    }

    public static void main(String[] args) {
        Solution471 solution471 = new Solution471();
        String      ans         = solution471.encode("aaa");
        System.out.println("ans:" + ans);

    }
}
