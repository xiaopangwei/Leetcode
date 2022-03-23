package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/21
 * @time 9:11 PM
 */
public class Solution233 {
    public int countDigitOne(int n) {
        // n= xxx i yyy
        if (n < 10) {
            return 1;
        }
        long ans  = 0;
        long base = 1;
        while (base <= n) {
            long low  = n % base;
            long high = (n / base) / 10;
            long cur  = (n / base) % 10;

            if (cur > 1) {
                ans += (high + (long) 1) * base;
            } else if (cur == 1) {
                ans += (high * base + low + (long) 1);
            } else {
                ans += (high * base);
            }
            System.out.println(high+" "+cur+" "+low+" "+ans);
            base *= 10;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        Solution233 solution233 = new Solution233();
        int         ans         = solution233.countDigitOne(123);
        System.out.println(ans);
    }
}
