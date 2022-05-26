package leetcode.p2022m05.day0514;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 10:26 AM
 */
public class Solution319 {
    public int bulbSwitch(int n) {

        if (n <= 1) {
            return n;
        }
        boolean[] flag = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                if (j % i == 0) {
                    flag[j] = !flag[j];
                }
            }
        }

        System.out.println(Arrays.toString(flag));
        int ans = 0;
        for (int i = 1; i < flag.length; i++) {
            ans += flag[i] ? 1 : 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution319 solution319 = new Solution319();
        for (int i = 6; i <= 6; i++) {
            int ans = solution319.bulbSwitch(i);
            System.out.println(i + " " + ans);
        }
    }
}
