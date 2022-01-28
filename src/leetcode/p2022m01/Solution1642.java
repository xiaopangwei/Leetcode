package leetcode.p2022m01;

import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/26
 * @time 11:03 PM
 */
public class Solution1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int                    i  = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (i < heights.length) {
            int j = i + 1;
            if (j >= heights.length) {
                break;
            }
            if (heights[j] <= heights[i]) {
                i = j;
            } else {
                int gap = heights[j] - heights[i];
                pq.add(gap);
                if (pq.size() > ladders) {
                    bricks -= pq.poll();
                }
                if (bricks < 0) {
                    return i;
                }
                i = j;
            }
        }

        return i;
    }


    public static void main(String[] args) {
        Solution1642 solution1642 = new Solution1642();
        int          ans          = solution1642.furthestBuilding(new int[]{1, 5, 1, 2, 3, 4, 10000}, 4, 1);
        System.out.println(ans);
    }

}
