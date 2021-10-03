package leetcode.p2021m10;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:11 PM
 */
public class Solution548 {
    public boolean splitArray(int[] nums) {

        if (nums.length < 7) {
            return false;
        }

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }


        int len = nums.length;
        for (int j = 2; j < len; j++) {

            Set<Integer> sumSet = new HashSet<>();
            for (int i = 0; i < j; i++) {
                if (i>=1 && j - i > 1 && prefixSum[j - 1] - prefixSum[i] == prefixSum[i - 1]) {
                    sumSet.add(prefixSum[i - 1]);

                }
            }

            for (int k = j + 2; k < len; k++) {

                if (k + 1 < len && k > j + 1) {
                    int s = prefixSum[len - 1] - prefixSum[k];
                    if (s == prefixSum[k - 1] - prefixSum[j]
                            && sumSet.contains(s)) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution548 solution548=new Solution548();
        boolean ans=solution548.splitArray(new int[]{1,2,1,2,1,2,1});
        System.out.println(ans);
    }

}
