package leetcode.p2021m09;

import leetcode.p2021m06.p20210629.Solution;

import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 9:47 PM
 */
public class Solution1167 {
    public int connectSticks(int[] sticks) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int item : sticks) {
            pq.add(item);
        }

        int cost = 0;
        while (pq.size() > 1) {
            int first  = pq.poll();
            int second = pq.poll();
            int temp   = first + second;
            cost += temp;
            pq.add(temp);
        }

        return cost;
    }

    public static void main(String[] args){
        Solution1167 solution1167=new Solution1167();
        int ans=solution1167.connectSticks(new int[]{2,4,3});
        System.out.println(ans);
    }
}
