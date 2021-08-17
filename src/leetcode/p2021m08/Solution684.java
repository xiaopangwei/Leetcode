package leetcode.p2021m08;

import common.uaf.UnionAndFind;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 10:57 AM
 */
public class Solution684 {
    public int[] findRedundantConnection(int[][] edges) {

        int length = edges.length;

        UnionAndFind uaf = new UnionAndFind(length);
        for (int i = 0; i < length; i++) {

            int first  = edges[i][0] - 1;
            int second = edges[i][1] - 1;
            if (uaf.find(first) != uaf.find(second)) {
                uaf.union(first, second);
            } else {
                return new int[]{edges[i][0], edges[i][1]};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution684 solution684 = new Solution684();
        int[]       ans         = solution684.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {2, 3}});
        System.out.println(Arrays.toString(ans));
    }
}
