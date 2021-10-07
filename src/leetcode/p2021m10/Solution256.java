package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/4
 * @time 10:13 AM
 */
public class Solution256 {
    public int minCost(int[][] costs) {

        int rows = costs.length - 2;
        int cols = costs[0].length;
        while (rows >= 0) {
            for (int i = 0; i < cols; i++) {
                int minVal = Integer.MAX_VALUE;
                for (int j = 0; j < cols; j++) {
                    if (i != j) {
//                        System.out.println(i + " " + j + " " + rows);
                        minVal = Math.min(minVal, costs[rows + 1][j]);
                    }
                }
                costs[rows][i] += minVal;
            }
            rows--;
        }

        int minCost = Integer.MAX_VALUE;

        for (int i = 0; i < cols; i++) {
            minCost = Math.min(minCost, costs[0][i]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        Solution256 solution256 = new Solution256();
        int         ans         = solution256.minCost(new int[][]{{7,6,2}});
        System.out.println(ans);
    }
}
