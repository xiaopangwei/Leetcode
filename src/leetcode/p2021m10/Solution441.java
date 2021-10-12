package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/10
 * @time 12:11 PM
 */
public class Solution441 {
    public int arrangeCoins(int n) {

        long left  = 1;
        long right = n;

        while (left <= right) {
            long mid  = (left + right) / 2;
            long temp = (mid * (mid + 1)) / 2;

            long sum = (long) n;
            if (temp <= sum) {
                long next = ((mid + 2) * (mid + 1)) / 2;
                if (next > sum) {
                    return (int) mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return (int) right;
    }

    public static void main(String[] args) {
        Solution441 solution441 = new Solution441();
        int ans = solution441.arrangeCoins(
                2147483647);
        System.out.println(ans);
    }
}
