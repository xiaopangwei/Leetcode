package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/17
 * @time 10:27 PM
 */
public class Solution400 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        if (n < 10) return n;
        long sum   = 0;
        long base  = 9;
        long digit = 1;
        long m     = (long) n;
        long prev  = 0;
        while (true) {
            prev = sum;
            sum += digit * base;
            if (prev <= m && m <= sum) {
                break;
            }
            base *= 10;
            digit++;
        }

        long gap = n - prev;
        long a   = (gap - 1) / digit;
        long b   = (gap - 1) % digit;

        long start = (long) Math.pow(10, digit - 1);

        return String.valueOf(start + a).charAt((int) b)-'0';
    }

    public static void main(String[] args) {
        Solution400 solution400 = new Solution400();
        solution400.findNthDigit(197);
    }
}
