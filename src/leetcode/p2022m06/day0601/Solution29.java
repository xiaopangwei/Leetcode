package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/9
 * @time 9:41 PM
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

        boolean sign  = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        long    a     = Math.abs((long) dividend);
        long    b     = Math.abs((long) divisor);
        long    left  = 1;
        long    right = a;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long t1  = multiply(mid, b);
            long t2  = multiply(mid + 1, b);
            if (t1 <= dividend && t2 > dividend) {
                if (sign) {
                    return (int) mid;
                }
                return (int) -mid;
            } else if (t2 < dividend) {
                left = mid + 1;
            } else if (t1 > dividend) {
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE;
    }

    private long multiply(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a == 1) {
            return (int) b;
        }
        if (b == 1) {
            return (int) a;
        }

        long ans  = 0;
        long base = a;
        while (base != 0) {
            long t = (base & 1);
            if (t == 1) {
                ans += b;
            }
            b += b;
            base >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        long       ans        = solution29.divide(10, 3);
        System.out.println(ans);
    }
}
