package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/24
 * @time 1:30 PM
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }

        if (divisor == 1) {
            return dividend;
        }
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long    a    = Math.abs((long) dividend);
        long    b    = Math.abs((long) divisor);

        long start = 1;
        long end   = a;

        while (start <= end) {
            long mid     = start + (end - start) / 2;
            long product = mul(b, mid);
            if (product > a) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (!sign) {
            end = -end;
        }
        if (end > Integer.MAX_VALUE || end < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) end;
        }
    }

    private long mul(long x, long y) {
        long ans = 0;
        while (y != 0) {
            if ((y & 1) == 1) {
                ans += x;
            }
            y >>= 1;
            x += x;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        int        ans        = solution29.divide(-2147483648, 2);
        System.out.println(ans);
    }
}
