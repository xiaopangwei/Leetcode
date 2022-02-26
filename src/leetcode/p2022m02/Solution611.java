package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/23
 * @time 8:55 AM
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = i - 1;
            int k = 0;
            while (k < j) {
                if (nums[k] + nums[j] > nums[i]) {
                    ans += j - k;
                    j--;
                } else {
                    k++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution611 solution611 = new Solution611();
        int         ans         = solution611.triangleNumber(new int[]{2,2,3,4});
        System.out.println(ans);
    }
}
