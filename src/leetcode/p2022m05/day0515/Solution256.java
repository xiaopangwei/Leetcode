package leetcode.p2022m05.day0515;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/15
 * @time 10:34 AM
 */
public class Solution256 {
    int[][] cached;

    public int minCost(int[][] costs) {
        cached = new int[costs.length][3];
        for (int i = 0; i < costs.length; i++) {
            Arrays.fill(cached[i], -1);
        }
        return Math.min(dfs(costs, 0, 0),
                Math.min(dfs(costs, 1, 0),
                        dfs(costs, 2, 0)));
    }

    private int dfs(int[][] costs, int color, int index) {
        if (index == costs.length) {
            return 0;
        }
        if (cached[index][color] != -1) {
            return cached[index][color];
        }
        int minVal = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {

            if (color == i) {
                continue;
            }
            int temp = dfs(costs, i, index + 1);
            if (temp != Integer.MAX_VALUE) {
                minVal = Math.min(temp + costs[index][color], minVal);
            }
        }
        cached[index][color] = minVal;
        return minVal;
    }

    public static void main(String[] args) {
        Solution256 solution256 = new Solution256();
        int         ans         = solution256.minCost(new int[][]{{3,5,3},{6,17,6},{7,13,18},{9,10,18}});
        System.out.println(ans);
    }
}
