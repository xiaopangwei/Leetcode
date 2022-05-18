package leetcode.p2022m05.day0514;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 2:15 PM
 */
public class Solution862 {

    //[84,-37,32,40,95]
    public int shortestSubarray(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + (long) nums[i];
        }

        System.out.println(Arrays.toString(prefixSum));
        int                 minLen = Integer.MAX_VALUE;
        LinkedList<Integer> list   = new LinkedList<>();
        for (int i = 0; i < prefixSum.length; i++) {
            if (list.isEmpty()) {
                list.addLast(i);
            } else {
                while (!list.isEmpty() && prefixSum[list.getLast()] > prefixSum[i]) {
                    list.removeLast();
                }
                list.addLast(i);
                while (true) {
                    int first = list.getFirst();
                    int last  = list.getLast();
                    if (last == first) {
                        break;
                    }
                    if (prefixSum[last] - prefixSum[first] >= k) {
                        minLen = Math.min(minLen, last - first);
                        list.removeFirst();
                    } else {
                        break;
                    }
                }

            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        int[]       array       = new int[]{2, -1, 2, 5};
        Solution862 solution862 = new Solution862();
        int         len         = solution862.shortestSubarray(array, 3);
        System.out.println(len);
    }
}
