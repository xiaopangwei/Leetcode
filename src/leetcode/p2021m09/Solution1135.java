package leetcode.p2021m09;

import common.uaf.UnionAndFind;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/6
 * @time 9:58 PM
 */
public class Solution1135 {
    public int minimumCost(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }
        Arrays.sort(connections, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[1];
            }
        });

        UnionAndFind unionAndFind = new UnionAndFind(n + 1);

        int count = 0;
        int cost  = 0;
        for (int[] item : connections) {
            int p1 = unionAndFind.find(item[0]);
            int p2 = unionAndFind.find(item[1]);
            if (p1 == p2) {
                continue;
            }
            unionAndFind.union(item[0], item[1]);
            count++;
            cost += item[2];
            if (count == n - 1) {
                break;
            }
        }

        if (count != n - 1) {
            return -1;
        }
        return cost;

    }

    public static void main(String[] args) {
        Solution1135 solution1135 = new Solution1135();
        int          cost         = solution1135.minimumCost(4, new int[][]{{1, 2, 3}, {3, 4, 4}});
        System.out.println(cost);

    }
}
