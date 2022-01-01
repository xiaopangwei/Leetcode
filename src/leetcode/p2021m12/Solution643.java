package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 10:43 PM
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int left  = 0;
        int right = k;
        int sum   = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double maxVal = sum;
        while (right < nums.length) {
            sum -= nums[left++];
            sum += nums[right++];
            maxVal = Math.max(maxVal, sum);
        }
        return maxVal / k;
    }

    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        double      max         = solution643.findMaxAverage(new int[]{5}, 1);
        System.out.println(max);
    }
}
