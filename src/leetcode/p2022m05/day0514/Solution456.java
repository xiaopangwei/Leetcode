package leetcode.p2022m05.day0514;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 11:13 AM
 */
public class Solution456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack  = new Stack<>();
        //我们从后往前做，维护一个「单调递减」的栈，同时使用 k 记录所有出栈元素的最大值
        int            maxVal = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < maxVal) {
                return true;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                maxVal = Math.max(stack.pop(), maxVal);
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] argd){
        Solution456 solution456=new Solution456();
        boolean ans=solution456.find132pattern(new int[]{3,1,4,2});
        System.out.println(ans);
    }
}
