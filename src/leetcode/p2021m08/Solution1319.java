package leetcode.p2021m08;

import common.uaf.UnionAndFind;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 11:10 AM
 */
public class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        int[] parents = new int[n];
        int[] rank    = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        UnionAndFind uaf = new UnionAndFind(parents, rank);

        int duplicatedNum = 0;
        for (int i = 0; i < connections.length; i++) {
            int first  = connections[i][0];
            int second = connections[i][1];
            if (uaf.find(first) != uaf.find(second)) {
                uaf.union(first, second);
            } else {
                duplicatedNum++;
            }
        }

        int uniqueParentNum = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == i) {
                uniqueParentNum++;
            }
        }

        if (duplicatedNum >= uniqueParentNum - 1) {
            return uniqueParentNum - 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution1319 solution1319 = new Solution1319();
        int          count        = solution1319.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}});
        System.out.println(count);
    }
}
