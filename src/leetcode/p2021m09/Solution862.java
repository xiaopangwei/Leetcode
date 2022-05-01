package leetcode.p2021m09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/18
 * @time 11:39 PM
 */
public class Solution862 {
    public int shortestSubarray(int[] A, int K) {
        int            ans       = Integer.MAX_VALUE;
        Deque<Integer> deque     = new ArrayDeque<>();
        long[]         prefixSum = new long[A.length+1];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + (long) A[i];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] > prefixSum[i]) {
                deque.removeLast();
            }

            while (!deque.isEmpty() && prefixSum[deque.peekFirst()] + K <= prefixSum[i]) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            deque.addLast(i);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    public static void main(String[] args) {
        Solution862 solution862 = new Solution862();
        System.out.println(solution862.shortestSubarray(new int[]{84, -37, 32, 40, 96}, 167));
    }

}
