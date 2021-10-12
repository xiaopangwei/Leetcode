package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/7
 * @time 11:18 AM
 */
public class Solution644 {

    double exp = 1e-5;

    public double findMaxAverage(int[] nums, int k) {


        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {

            maxVal = Math.max(maxVal, nums[i]);
            minVal = Math.min(minVal, nums[i]);
        }
        double left  = minVal;
        double right = maxVal;

        while (left + exp <= right) {
            double  mid  = (left + right) * 1.0 / 2;
            boolean isOk = false;

            double prefixSum    = 0;
            double prev         = 0;
            double minPrefixSum = 0;
            for (int i = 0; i < k; i++) {
                prefixSum += nums[i] - mid;
            }
            if (prefixSum >= 0) {
                isOk = true;
            } else {
                for (int i = k; i < nums.length; i++) {
                    prefixSum += nums[i] - mid;
                    prev += nums[i - k] - mid;
                    if (prev < minPrefixSum) {
                        minPrefixSum = prev;
                    }
                    if (prefixSum - minPrefixSum >= 0) {
                        isOk = true;
                        break;
                    }
                }
            }
            if (isOk) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution644 solution644 = new Solution644();
        double      ans         = solution644.findMaxAverage(new int[]{5}, 1);
        System.out.println(ans);
    }
}
