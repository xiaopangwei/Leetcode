package leetcode.p2022m06.day0601;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/5
 * @time 9:19 PM
 */
public class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        int sum=0;

        for (int i = 0; i < n - 1; i++) {
            if (heights[i] > heights[i + 1]) {
                continue;
            }
            int gap = heights[i + 1] - heights[i];
            pq.add(gap);
            if (pq.size()>ladders){
                sum+=pq.poll();
            }
            if (sum>bricks){
                return i;
            }
        }

        return heights.length-1;
    }

    public static void main(String[] args){
        int[] array=new int[]{4,12,2,7,3,18,20,3,19};
        Solution1642 solution1642=new Solution1642();
        int ans=solution1642.furthestBuilding(array,10,2);
        System.out.println(ans);
    }
}
