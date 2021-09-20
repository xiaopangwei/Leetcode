package leetcode.p2021m09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/18
 * @time 11:39 PM
 */
public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {

        int[]          prefixSum = new int[nums.length + 1];
        Deque<Integer> deque     = new LinkedList<>();

        int ans = Integer.MAX_VALUE;
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[i]) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                int len = i - deque.peekFirst();
                ans = Math.min(ans, len);
                deque.removeFirst();
            }

            deque.addLast(i);
        }

        if (ans == Integer.MAX_VALUE) {
            return -1;
        } else {
            return ans;
        }

    }

    public static void main(String[] args) {
        Solution862 solution862 = new Solution862();
        System.out.println(solution862.shortestSubarray(new int[]{1}, 1));
    }

}
