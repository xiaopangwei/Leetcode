package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/29
 * @time 10:42 PM
 */
public class Solution2439 {
    public int minimizeArrayValue(int[] nums) {
        long ans = 0;
        long sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += (long) nums[i];
            long t = 0;
            if (sum % (i + 1) == 0) {
                t = sum / (i + 1);
            } else {
                t += 1;
            }
            ans = Math.max(t, ans);
        }
        return (int) ans;
    }
}
