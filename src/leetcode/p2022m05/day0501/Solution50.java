package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 1:51 PM
 */
public class Solution50 {
    public double myPow(double x, int n) {
        return longPow(x, (long) n);
    }

    public double longPow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        boolean flag = true;
        if (n < 0) {
            n = -n;
            flag = false;
        }
        long   last = n & 1;
        double temp = longPow(x, n / 2);
        double ans  = temp * temp;
        if (last == 1) {
            ans *= x;
        }
        if (!flag) {
            return 1.0 / ans;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        double     ans        = solution50.myPow(2.0, -2);
        System.out.println(ans);
    }

}

