package leetcode.p2022m06.day0601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 8:12 PM
 */
public class Solution743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        pq.add(new int[]{k, 0});
        minDist[k] = 0;
        while (!pq.isEmpty()) {
            int[] temp      = pq.poll();
            System.out.println("poll:"+Arrays.toString(temp));
            int   index     = temp[0];
            int   relayDist = temp[1];

            for (int[] item : times) {
                if (item[0] == index) {
                    int d = relayDist + item[2];
                    if (d < minDist[item[1]]) {
                        minDist[item[1]] = d;
                        pq.add(new int[]{item[1], d});
                        System.out.println("add:"+Arrays.toString(new int[]{item[1], d}));
                    }
                }
            }
        }


        System.out.println(Arrays.toString(minDist));

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < minDist.length; i++) {
            ans = Math.max(ans, minDist[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        //[[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        Solution743 solution743 = new Solution743();
        int         ans         = solution743.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);
        System.out.println(ans);
    }

}
