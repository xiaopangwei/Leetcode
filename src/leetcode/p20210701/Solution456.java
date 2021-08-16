package leetcode.p20210701;

import leetcode.p20210629.Solution433;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/3
 * @time 9:47 AM
 */
public class Solution456 {
    public static void main(String[] args){
        int[] a1=new int[]{1,2,3,4};
        int[] a2=new int[]{3,1,4,2};
        int[] a3=new int[]{3,5,0,3,4};
        Solution456 solution456=new Solution456();
        System.out.println(solution456.find132pattern(a1));
        System.out.println(solution456.find132pattern(a2));
        System.out.println(solution456.find132pattern(a3));
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length<3) return false;
        Stack<Integer> stack=new Stack<>();
        int max=Integer.MIN_VALUE;
        for (int i=nums.length-1;i>=0;i--){
           while (!stack.isEmpty() && nums[i]>nums[stack.peek()]){
                    int index=stack.pop();
                    max=Math.max(nums[index],max);
           }
           if (nums[i]<max){
               return true;
           }
           else {
               stack.push(i);
           }

        }
        return false;
    }



}
