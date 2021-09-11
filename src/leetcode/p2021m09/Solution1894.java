package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/10
 * @time 2:46 PM
 */
public class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {

        long[] prefixSum = new long[chalk.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + chalk[i - 1];
        }

        long maxSum = prefixSum[prefixSum.length - 1];

        int remained = k;
        while (remained >= maxSum) {
            remained -= maxSum;
        }
        //第一个比k大的索引
        int left   = 0;
        int right  = prefixSum.length - 1;
        int target = remained;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

//        System.out.println(left);
//        if (left-1>=0){
            return left - 1;
//        }else{
//            return chalk.length-1;
//        }

    }

    public static void main(String[] args) {
        Solution1894 solution1894 = new Solution1894();
        int          ans          = solution1894.chalkReplacer(new int[]{3, 4, 1, 2}, 25);
        System.out.println(ans);
    }
}
