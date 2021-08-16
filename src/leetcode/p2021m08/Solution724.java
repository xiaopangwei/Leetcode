package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 11:06 AM
 */
public class Solution724 {
    public int pivotIndex(int[] nums) {

        int   len    = nums.length;
        int[] prefix = new int[len];

        prefix[0] = 0;
        int sum = nums[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            sum += nums[i];
        }

        for (int i = 0; i < len; i++) {
            int leftSum  = prefix[i];
            int rightSum = sum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Solution724 solution724 = new Solution724();
        int         ans         = solution724.pivotIndex(new int[]{1});
        System.out.println(ans);
    }
}
