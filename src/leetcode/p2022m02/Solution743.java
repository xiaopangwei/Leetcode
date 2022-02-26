package leetcode.p2022m02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/21
 * @time 8:29 PM
 */
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distanceArray = new int[n + 1];
        Arrays.fill(distanceArray, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        pq.add(new int[]{0, k});
        distanceArray[k] = 0;
        while (!pq.isEmpty()) {
            int[] temp   = pq.poll();
            int   dist   = temp[0];
            int   target = temp[1];
            if (distanceArray[target] < dist) {
                continue;
            }
            for (int i = 0; i < times.length; i++) {
                if (target == times[i][0]) {
                    int nextNode = times[i][1];
                    int newDist  = times[i][2] + dist;
                    if (distanceArray[nextNode] > newDist) {
                        distanceArray[nextNode] = newDist;
                        pq.add(new int[]{newDist, nextNode});
                    }
                }
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < distanceArray.length; i++) {
            if (distanceArray[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                maxVal = Math.max(maxVal, distanceArray[i]);
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        Solution743 solution743 = new Solution743();
        int         ans         = solution743.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
        System.out.println(ans);
    }
}
