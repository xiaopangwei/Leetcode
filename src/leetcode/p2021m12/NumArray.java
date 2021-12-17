package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/14
 * @time 10:05 PM
 */
public class NumArray {
    int[] array;
    int[] prefixSum;

    public NumArray(int[] nums) {
        array = nums;

        if (nums.length > 0) {
            prefixSum[0] = nums[0];
            for (int i = 1; i < prefixSum.length; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int left, int right) {
        int t = 0;
        if (left > 0) {
            t = this.prefixSum[left - 1];
        }
        return this.prefixSum[right] - t;
    }
}
