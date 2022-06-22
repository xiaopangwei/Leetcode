package leetcode.p2022m06.day0612;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/16
 * @time 9:20 PM
 */
public class Solution528 {
    int[] prefixSum;

    public Solution528(int[] w) {

        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int left  = 0;
        int r     = (int) (Math.random() * prefixSum[prefixSum.length - 1]) + 1;
        int right = prefixSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] >= r) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
