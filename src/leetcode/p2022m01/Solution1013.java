package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 11:16 AM
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        int avg = sum / 3;

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        sum=prefixSum[arr.length-1];
        if (sum % 3 != 0) {
            return false;
        }

        int left  = 0;
        int right = arr.length - 1;

        while (left <= right-2) {

            int s1 = prefixSum[left];
            int s2 = prefixSum[arr.length - 1] - prefixSum[right - 1];
            int s3 = sum - s1 - s2;
            if (s1 == avg && s2 == avg && s3 == avg) {
                return true;
            }
            if (s1 != avg) {
                left++;
            }
            if (s2 != avg) {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1013 solution1013 = new Solution1013();
        boolean      ans          = solution1013.canThreePartsEqualSum(new int[]{1, -1, 1, -1});
        System.out.println(ans);
    }
}
