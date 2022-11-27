package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/20
 * @time 9:50 PM
 */
public class Solution799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row + 1][query_glass + 1];
        dp[0][0] = (double) poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= query_glass; j++) {
                double t1 = 0;
                double t2 = 0;
                if (dp[i - 1][j] > 1) {
                    t1 = (dp[i - 1][j] - 1) / 2;
                }
                if (j - 1 >= 0 && dp[i - 1][j - 1] > 1) {
                    t2 = (dp[i - 1][j - 1] - 1) / 2;
                }
                dp[i][j] += (t1 + t2);
            }

        }

        if (dp[query_row][query_glass] <= 1) {
            return dp[query_row][query_glass];
        }
        return 1;
    }

    public static void main(String[] args){
        Solution799 solution799=new Solution799();
        System.out.println(solution799.champagneTower(2,1,1));
    }
}
