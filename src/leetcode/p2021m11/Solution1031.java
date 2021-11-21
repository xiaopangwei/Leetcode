package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/14
 * @time 10:09 AM
 */
public class Solution1031 {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {

        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int maxSum = 0;

        int maxLeftSum = 0;
        //L-M
        for (int i = 0; i < prefixSum.length; i++) {
            int index1 = i - firstLen;
            int index2 = i + secondLen;

            if (index1 < 0 || index2 >= prefixSum.length) {
                continue;
            }

            //[index1,i]
            // i-(index1+1)+1=i-(i-firstLen+1)+1=firstLen
            //[i,index2]
            // index2-(i+1)+1=i + secondLen-i=secondLen

            int leftSum  = prefixSum[i] - prefixSum[index1];
            int rightSum = prefixSum[index2] - prefixSum[i];

            maxLeftSum = Math.max(maxLeftSum, leftSum);

            maxSum = Math.max(maxSum, maxLeftSum + rightSum);

        }

        //M-L
        maxLeftSum = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            int index1 = i - secondLen;
            int index2 = i + firstLen;

            if (index1 < 0 || index2 >= prefixSum.length) {
                continue;
            }


            int leftSum  = prefixSum[i] - prefixSum[index1];
            int rightSum = prefixSum[index2] - prefixSum[i];

            maxLeftSum = Math.max(maxLeftSum, leftSum);

            maxSum = Math.max(maxSum, maxLeftSum + rightSum);

        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution1031 solution1031 = new Solution1031();
        int[]        nums         = new int[]{2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int          sum          = solution1031.maxSumTwoNoOverlap(nums, 4, 3);
        System.out.println(sum);
    }
}
