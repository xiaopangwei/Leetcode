package leetcode.p2022m06.day0601;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/4
 * @time 1:40 PM
 */
public class Solution862 {
    public int shortestSubarray(int[] nums, int k) {
        LinkedList<Integer> list   = new LinkedList<>();
        long[]              prefix = new long[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + (long) nums[i - 1];
        }

//        System.out.println(Arrays.toString(prefix));
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < prefix.length; i++) {
            if (list.isEmpty()) {
                list.add(i);
            } else {
                while (!list.isEmpty() && prefix[list.getLast()] > prefix[i]) {
                    list.pollLast();
                }
                list.addLast(i);
                while (!list.isEmpty()) {
                    if (prefix[list.getLast()] - prefix[list.getFirst()] >= k) {
                        int t = list.getLast() - list.getFirst();
                        minLen = Math.min(minLen, t);
                        list.pollFirst();
                    } else {
                        break;
                    }
                }

            }
        }
        return Integer.MAX_VALUE == minLen ? -1 : minLen;
    }

    public static void main(String[] args) {
        Solution862 solution862 = new Solution862();
        int         min         = solution862.shortestSubarray(new int[]{1}, 1);
        System.out.println(min);
    }
}
