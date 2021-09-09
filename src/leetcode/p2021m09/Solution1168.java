package leetcode.p2021m09;

import common.uaf.UnionAndFind;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 9:54 PM
 */
public class Solution1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        for (int i = 0; i < pipes.length; i++) {
            pq.add(new int[]{pipes[i][0], pipes[i][1], pipes[i][2]});
        }
        //4,1,1
        //4,2,2
        //4,3,2
        for (int i = 0; i < n; i++) {
            int[] array = new int[]{n + 1, i + 1, wells[i]};
            pq.add(array);
        }

        int          cost         = 0;
        UnionAndFind unionAndFind = new UnionAndFind(n + 2);
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int   p1   = unionAndFind.find(temp[0]);
            int   p2   = unionAndFind.find(temp[1]);
            if (p1 == p2) {
                continue;
            }
            cost += temp[2];
            unionAndFind.union(temp[0], temp[1]);
        }
        return cost;
    }

    public static void main(String[] args) {
        Solution1168 solution1168 = new Solution1168();
        int          ans          = solution1168.minCostToSupplyWater(3, new int[]{1, 2, 2}, new int[][]{{1, 2, 1}, {2, 3, 1}});
        System.out.println(ans);
    }

}
