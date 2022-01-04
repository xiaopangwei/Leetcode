package leetcode.p2021m12;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 3:56 PM
 */
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new int[]{};
        } else if (len == 1) {
            return new int[]{-1};
        }
        int   doubleLen = len * 2;
        int[] newNums   = new int[doubleLen];
        System.arraycopy(nums, 0, newNums, 0, len);
        System.arraycopy(nums, 0, newNums, len, len );
        int[] ans = new int[doubleLen];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        int            i     = 0;
        while (i < newNums.length) {
            while (!stack.isEmpty() && newNums[stack.peek()] < newNums[i]) {
                int idx = stack.pop();
                ans[idx] = newNums[i];
            }
            stack.push(i);
            i++;
        }

        int[] res = new int[len];
        System.arraycopy(ans, 0, res, 0, len);
        return res;
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[]       res         = solution503.nextGreaterElements(new int[]{-2,-1});
        System.out.println(Arrays.toString(res));
    }
}
