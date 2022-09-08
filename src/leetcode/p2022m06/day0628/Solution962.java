package leetcode.p2022m06.day0628;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/4
 * @time 9:57 PM
 */
public class Solution962 {
    public int maxWidthRamp(int[] nums) {

        //单调递减序列
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }
            if (nums[stack.peek()] >= nums[i]) {
                stack.push(i);
            }
        }

        int maxVal = 0;

        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxVal = Math.max(maxVal, i-stack.peek());
                stack.pop();
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
        Solution962 solution962=new Solution962();
        int ans=solution962.maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
        System.out.println(ans);
    }
}
