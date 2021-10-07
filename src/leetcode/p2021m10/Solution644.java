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


        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
            maxVal = Math.max(maxVal, nums[i - 1]);
            minVal = Math.min(minVal, nums[i - 1]);
        }
        double left  = minVal;
        double right = maxVal;

        while (left + exp <= right) {
            double mid = (left + right)*1.0 / 2;
            System.out.println(mid);
            boolean isOk = false;
            for (int len = k; len <= nums.length; len++) {
                for (int i = 0; i < nums.length; i++) {
                    int j = len + i - 1;
                    if (j >= nums.length) {
                        continue;
                    }
                    double sum = prefixSum[j + 1] - prefixSum[i];
                    if (sum >= len * mid) {
                        isOk = true;
                        break;
                    }
                }
            }

//            System.out.println(mid + " " + isOk);
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
