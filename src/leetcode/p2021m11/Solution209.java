package leetcode.p2021m11;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/8
 * @time 10:16 PM
 */
public class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {


        int   minLen    = nums.length + 1;
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        System.out.println(Arrays.toString(prefixSum));

        for (int i = 0; i < prefixSum.length-1; i++) {
            int sum = s + prefixSum[i];
            int idx = Arrays.binarySearch(prefixSum, sum);
            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx<prefixSum.length) {
                minLen = Math.min(minLen, idx - i);
            }
//            System.out.println(i+" "+minLen);
        }
        return minLen==nums.length+1?0:minLen;
    }

    public static void main(String[] args) {
//        Solution209 solution209 = new Solution209();
//        int         ans         = solution209.minSubArrayLen(4, new int[]{1,4,4});
//        System.out.println(ans);

        int a=Arrays.binarySearch(new int[]{1,2,4,7,9},50);
        if (a<0){
            System.out.println(-a-1);
        }else{
            System.out.println(a);
        }
    }
}
