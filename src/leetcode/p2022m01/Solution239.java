package leetcode.p2022m01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 1:43 PM
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o2[1] - o1[1];
            }
        });

        int[] res   = new int[nums.length - k + 1];
        int   index = 0;

        int i = 0;
        for (i = 0; i < k; i++) {
            pq.add(new int[]{i, nums[i]});
        }

        res[index++] = pq.peek()[1];


        while (i < nums.length) {
            pq.add(new int[]{i, nums[i]});
            while (true) {
                int[] temp = pq.peek();
                if (temp[0] > i - k) {
                    res[index++] = temp[1];
                    break;
                } else {
                    pq.poll();
                }
            }
            i++;
        }

        return res;

    }

    public static void main(String[] args){
        Solution239 solution239=new Solution239();
        int[] ans=solution239.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        System.out.println(Arrays.toString(ans));
    }
}
