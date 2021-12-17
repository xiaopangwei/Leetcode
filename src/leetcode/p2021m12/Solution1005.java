package leetcode.p2021m12;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/3
 * @time 10:10 PM
 */
public class Solution1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int val = pq.poll();
            pq.add(-val);
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution1005 solution1005 = new Solution1005();
        int          sum          = solution1005.largestSumAfterKNegations(new int[]{3,-1,0,2}, 1);
        System.out.println(sum);
    }
}
