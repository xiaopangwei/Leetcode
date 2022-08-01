package leetcode.p2022m07;

import common.uaf.UnionAndFind;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/20
 * @time 10:33 PM
 */
public class Solution827 {
    public int largestIsland(int[][] grid) {

        int          m            = grid.length;
        int          n            = grid[0].length;
        UnionAndFind unionAndFind = new UnionAndFind(m * n);
        int          max          = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        unionAndFind.union(i * n + j, (i + 1) * n + j);
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        unionAndFind.union(i * n + j, i * n + j + 1);
                    }
                }
            }
        }

        int[] rank = unionAndFind.rank;
        int   t    = rank[0];
        for (int i = 1; i < rank.length; i++) {
            t = Math.max(t, rank[i]);
        }

        max = Math.max(max, t);


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int          index = i * n + j;
                    Set<Integer> set   = new HashSet<>();
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        set.add(unionAndFind.find(index + n));
                    }
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        set.add(unionAndFind.find(index - n));
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        set.add(unionAndFind.find(index + 1));
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        set.add(unionAndFind.find(index - 1));
                    }

                    int temp = 1;
                    for (int item : set) {
                        temp += unionAndFind.rank[item];
                    }
                    max = Math.max(max, temp);
                }

            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution827 solution827 = new Solution827();
        int         ans         = solution827.largestIsland(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
        System.out.println(ans);
    }
}
