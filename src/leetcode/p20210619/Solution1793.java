package leetcode.p20210619;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/24
 * @time 1:00 PM
 */
public class Solution1793 {
    public int maximumScore(int[] nums, int k) {
        int            maxVal = Integer.MIN_VALUE;
        Stack<Integer> stack  = new Stack<>();
        int            len    = nums.length;
        int[]          left   = new int[len];
        int[]          right  = new int[len];
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            } else {
                left[i] = -1;
            }
            stack.push(i);
        }


        stack.clear();
        for (int i=len-1;i>=0;i--){

            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }

            if(!stack.isEmpty()) {
                right[i]=stack.peek();
            }else{
                right[i]=len;
            }

            stack.push(i);
        }


        for (int i=0;i<len;i++)
        {
            if (k>=left[i] && k<=right[i]) {
                int width  = right[i] - left[i] - 1;
                int height = nums[i];
                maxVal = Math.max(width * height, maxVal);
            }
        }
        return maxVal;

    }


    public static void main(String[] args){
        Solution1793 solution1793=new Solution1793();
        System.out.println(solution1793.maximumScore(new int[]{1,4,3,7,4,5},3));
        System.out.println(solution1793.maximumScore(new int[]{5,5,4,5,4,1,1,1},0));

    }


}
