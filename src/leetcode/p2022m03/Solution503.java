package leetcode.p2022m03;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 2:47 PM
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] copy = new int[nums.length * 2];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        System.arraycopy(nums, 0, copy, nums.length, nums.length);

        Stack<Integer> stack = new Stack<>();
        int[]          ans   = new int[copy.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < copy.length; i++) {
            while (!stack.isEmpty() && copy[stack.peek()] < copy[i]) {
                ans[stack.pop()] = copy[i];
            }
            stack.push(i);
        }
        return Arrays.copyOf(ans,nums.length);
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[]       ans         = solution503.nextGreaterElements(new int[]{1,2,3,4,3});
        System.out.println(Arrays.toString(ans));
    }
}
