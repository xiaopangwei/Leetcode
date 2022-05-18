package leetcode.p2022m05.day0508;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 11:01 PM
 */
public class Solution1653 {
    public int minimumDeletions(String s) {

        int[] dp = new int[s.length()];

        int countB = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'b') {
                dp[i] = get(dp, i - 1);
                countB++;
            } else {
                //保留a,删除所有的b
                //删除a
                dp[i] = Math.min(countB, get(dp, i - 1) + 1);
            }
        }

        return dp[dp.length - 1];
    }

    public int get(int[] dp, int i) {
        if (i <= 0) {
            return 0;
        }
        return dp[i];
    }


    public static void main(String[] args) {
        Solution1653 solution1653 = new Solution1653();
        int          ans          = solution1653.minimumDeletions("bbaaaaabb");
        System.out.println(ans);
    }

}
