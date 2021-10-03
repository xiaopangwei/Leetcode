package leetcode.p2021m10;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 11:31 PM
 */
public class Solution1099 {
    public int twoSumLessThanK(int[] nums, int k) {

        Arrays.sort(nums);
        int i   = 0;
        int j   = nums.length - 1;
        int ans = -1;
        int gap = Integer.MAX_VALUE;
        while (i < j) {
            int s = nums[i] + nums[j];
            if (s == k) {
                return k;
            } else if (s < k) {
                int diff = Math.abs(s - k);
                if (diff < gap) {
                    gap = diff;
                    ans = s;
                }
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1099 solution1099 = new Solution1099();
        int          ans          = solution1099.twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60);
        System.out.println(ans);


    }
}
