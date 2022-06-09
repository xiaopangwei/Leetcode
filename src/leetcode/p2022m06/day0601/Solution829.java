package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/3
 * @time 9:55 AM
 */
public class Solution829 {
    public int consecutiveNumbersSum(int n) {

        int ans    = 0;
        int target = 2 * n;
        for (int i = 1; i * (i + 1) <= target; i++) {
            if (target % i == 0 && (target / i -i) % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution829 solution829 = new Solution829();
        int         n           = solution829.consecutiveNumbersSum(10);
        System.out.println(n);
    }
}
