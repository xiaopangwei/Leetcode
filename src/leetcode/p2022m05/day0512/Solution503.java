package leetcode.p2022m05.day0512;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:43 PM
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int idx = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[idx]) {
                ans[stack.pop()] = nums[idx];
            }
            stack.push(idx);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[]       ans         = solution503.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        System.out.println(Arrays.toString(ans));
    }

}
