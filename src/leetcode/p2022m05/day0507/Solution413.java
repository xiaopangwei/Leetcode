package leetcode.p2022m05.day0507;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 2:38 PM
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int cnt = 0;
        int t   = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] + nums[i - 2] == 2 * nums[i - 1]) {
                t++;
            } else {
                t = 0;
            }
            cnt += t;
        }

//        for (int i = 0; i < dp.length; i++) {
//            cnt += dp[i];
//        }
//        System.out.println(Arrays.toString(dp));
        return cnt;
    }

    public static void main(String[] args) {
        Solution413 solution413 = new Solution413();
        int         ans         = solution413.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        System.out.println(ans);
    }
}
