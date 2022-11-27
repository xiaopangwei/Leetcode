package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/22
 * @time 9:34 PM
 */
public class Solution878 {
    public int nthMagicalNumber(int n, int a, int b) {
        int  mod   = 1000000007;
        long left  = (long) Math.min(a, b);
        long right = (long) n * (long) (Math.max(a, b));
        while (left < right) {
            long mid  = left + (right - left) / 2;
            long temp = getMagicalNumsCount(a, b, mid);
            if (temp < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) (left % mod);
    }


    private long getMagicalNumsCount(long a, long b, long n) {
        return n / a + n / b - n / (lcm(a, b));
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution878 solution878 = new Solution878();
        int         ans         = solution878.nthMagicalNumber(2, 7, 3);
        System.out.println(ans);
    }
}
