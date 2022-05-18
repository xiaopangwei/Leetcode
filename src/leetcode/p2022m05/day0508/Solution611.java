package leetcode.p2022m05.day0508;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 9:20 PM
 */
public class Solution611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int left  = 0;
            int right = i - 1;

            while (left < right) {
                if (nums[left] + nums[right] <= nums[i]) {
                    left++;
                } else {
                    //[left,...right-1]
                    ans += (right - left);
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution611 solution611=new Solution611();
        int ans=solution611.triangleNumber(new int[]{2,2,3,4});
        System.out.println(ans);
    }
}
