package leetcode.p2022m06.day0601;

import leetcode.p2021m06.p20210619.StockSpanner;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/4
 * @time 10:54 AM
 */
public class TreeAncestor {
    int[][] dp;

    public TreeAncestor(int n, int[] parent) {
        dp = new int[n][20];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][0] = parent[i];
            for (int j = 1; j <= dp[i].length; j++) {
                int t = dp[i][j - 1];
                if (t != -1) {
                    dp[i][j] = dp[t][j - 1];
                } else {
                    break;
                }
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

    }

    public int getKthAncestor(int node, int k) {
        return dfs(node, k);
    }


    private int dfs(int node, int k) {
        if (node < 0 || k < 0) {
//            System.out.println(-1);
            return -1;
        }
        if (k == 0) {
            System.out.println(node);
            return node;
        }
        int t = (int) Math.log(k);

        int remained = k - (int) Math.pow(2, t);


        return dfs(dp[node][t], remained);

    }

    public static void main(String[] args) {

        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        treeAncestor.getKthAncestor(3, 1);
        treeAncestor.getKthAncestor(5, 2);
        treeAncestor.getKthAncestor(6, 3);


    }
}
