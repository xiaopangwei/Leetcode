package leetcode.p2021m09;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/14
 * @time 8:20 PM
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length<2){
            return false;
        }
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0]=0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        Set<Integer> sets = new HashSet<>();
        for (int i = 2; i < prefixSum.length; i++) {
            sets.add(prefixSum[i - 2] % k);
            int temp = prefixSum[i] % k;
            if (sets.contains(temp)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution523 solution523 = new Solution523();
        boolean     ans         = solution523.checkSubarraySum(new int[]{23, 2,  6,4, 7}, 13);
        System.out.println(ans);
    }
}
