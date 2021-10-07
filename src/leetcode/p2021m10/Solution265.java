package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 9:34 AM
 */
public class Solution265 {
    public int minCostII(int[][] costs) {

        int idx = 0;
        int m   = costs.length;
        int n   = costs[0].length;



        int firstMinVal  = 0;
        int secondMinVal = 0;
        int firstIndex   = -1;

        while (idx < m) {

            int tIndex = -1;
            int t1     = Integer.MAX_VALUE;
            int t2     = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (i == firstIndex) {
                    costs[idx][i] += secondMinVal;
                } else {
                    costs[idx][i] += firstMinVal;
                }

                if (costs[idx][i] < t1) {
                    t2 = t1;
                    t1 = costs[idx][i];
                    tIndex = i;
                } else if (costs[idx][i] < t2) {
                    t2 = costs[idx][i];
                }
            }



            firstMinVal = t1;
            secondMinVal = t2;
            firstIndex = tIndex;

            idx++;
        }



        return firstMinVal;

    }

    public static void main(String[] args) {
        Solution265 solution265 = new Solution265();
        int         ans         = solution265.minCostII(new int[][]{{8, 16, 12, 18, 9}, {19, 18, 8, 2, 8}, {8, 5, 5, 13, 4}, {15, 9, 3, 19, 2}, {8, 7, 1, 8, 17}, {8, 2, 8, 15, 5}, {8, 17, 1, 15, 3}, {8, 8, 5, 5, 16}, {2, 2, 18, 2, 9}});
        System.out.println(ans);
    }
}
