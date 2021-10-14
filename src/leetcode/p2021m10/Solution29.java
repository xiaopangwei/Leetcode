package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/12
 * @time 4:58 PM
 */
public class Solution29 {
    public int divide(int a, int b) {


        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        long dividend = (long) a;
        long divisor  = (long) b;
        if (dividend == 0) {
            return 0;
        }

        boolean flag = true;
        if (dividend < 0 && divisor > 0) {
            flag = false;
        }
        if (dividend > 0 && divisor < 0) {
            flag = false;
        }

        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }


        if (divisor == 1) {
            if (flag) {
                return (int) dividend;
            } else {
                return (int) -dividend;
            }
        }

        long left  = 0;
        long right = dividend;


        long positiveValue = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long temp = multiply(mid, divisor);

            if (temp <= dividend) {
                if (multiply(mid + 1, divisor) > dividend) {
                    positiveValue = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }

        if (positiveValue > Integer.MAX_VALUE) {
            positiveValue = Integer.MAX_VALUE;
        }
        if (flag) {
            return (int) positiveValue;
        } else {
            return (int) -positiveValue;
        }
    }

    private long multiply(long a, long b) {

        long res = 0;
        while (b != 1) {
            long t = b & 1;
            if (t == 1) {
                res += a;
            }
            a += a;
            b = b >> 1;
        }
        return (res + a);
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
        System.out.println(solution29.multiply(11, 11));
        System.out.println(solution29.multiply(11, 12));
        System.out.println(solution29.multiply(12, 12));
        int ans = solution29.divide(2147483647, 2);
        System.out.println(ans);
    }
}
