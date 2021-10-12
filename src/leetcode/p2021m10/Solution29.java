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
    public int divide(int dividend, int divisor) {

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

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int left  = 0;
        int right = dividend;


        int positiveValue = 0;
        while (left <= right) {
            int mid  = (left + right) / 2;

//            System.out.println(mid);
            int temp = multiply(mid, divisor);

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

        if (flag) {
            return positiveValue;
        } else {
            return -positiveValue;
        }
    }

    private int multiply(int a, int b) {

        int res = 0;
        while (b != 1) {
            int t = b & 1;
            if (t == 1) {
                res += a;
            }
            a += a;
            b = b >> 1;
        }
        return res+a;
    }

    public static void main(String[] args) {
        Solution29 solution29 = new Solution29();
//        int        ans        = solution29.multiply(3, 1);
        int        ans        = solution29.divide(7, -3);
        System.out.println(ans);
    }
}
