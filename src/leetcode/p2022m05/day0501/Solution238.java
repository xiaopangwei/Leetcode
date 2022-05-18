package leetcode.p2022m05.day0501;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 4:06 PM
 */
public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        //ans[i] [0,i)的乘积
        //left [0,i]的乘积 初始化为1
        Arrays.fill(ans, 1);
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }

    public static void main(String[] args){
        Solution238 solution23=new Solution238();
        int[] ans=solution23.productExceptSelf(new int[]{-1,1,0,-3,3});
        System.out.println(Arrays.toString(ans));
    }

}
