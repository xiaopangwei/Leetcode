package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/22
 * @time 10:12 PM
 */
public class Solution204 {
    public int countPrimes(int n) {

        //false为true表示是素数
        boolean[] flag = new boolean[n + 1];
        if (n <= 1) {
            return n;
        }
        Arrays.fill(flag, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                count++;
                long temp = (long)i*(long) i;
                if (temp >= n) {
                    continue;
                }
                for (int j =i*i; j < n; j += i) {
                    flag[j] = false;
                }

            }
        }

        return count;

    }

    public static void main(String[] args) {
        Solution204 solution204 = new Solution204();
        int         m           = solution204.countPrimes(499979);
        System.out.println(m);
    }
}
