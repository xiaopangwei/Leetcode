package leetcode.springfestival.pm20220203;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 3:32 PM
 */
public class Solution973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int dist1 = o1[0] * o1[0] - o1[1] * o1[1];
                int dist2 = o2[0] * o2[0] - o2[1] * o2[1];
                return dist2 - dist1;
            }
        });

        for (int[] p : points) {
            if (pq.size() < k) {
                pq.add(p);
            } else {
                int   currDist = p[0] * p[0] + p[1] * p[1];
                int[] q        = pq.peek();
                int   peekDist = q[0] * q[0] + q[1] * q[1];
                if (currDist < peekDist) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        int[][] ans = new int[k][2];
        int     idx = 0;
        while (!pq.isEmpty()) {
            ans[idx++] = pq.poll();
        }

        return ans;
    }
}
