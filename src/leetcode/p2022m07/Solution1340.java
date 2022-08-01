package leetcode.p2022m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/24
 * @time 8:11 PM
 */
public class Solution1340 {
    int[] dp;
    int   d;
    int[] arr;
    int   n;

    public int maxJumps(int[] arr, int d) {
        this.n = arr.length;
        this.d = d;
        dp = new int[n];
        this.arr = arr;
        Arrays.fill(dp, -1);

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.max(ans, dfs(i));
        }
        return ans + 1;
    }


    private int dfs(int startIndex) {
        if (dp[startIndex] != -1) {
            return dp[startIndex];
        }
        int leftMost  = Math.max(0, startIndex - d);
        int rightMost = Math.min(n - 1, startIndex + d);

        int ans = 0;
        for (int i = leftMost; i < startIndex; i++) {
            if (arr[i] < arr[startIndex]) {
                ans = Math.max(ans, dfs(i));
            } else {
                break;
            }
        }

        for (int i = startIndex + 1; i <= rightMost; i++) {
            if (arr[i] < arr[startIndex]) {
                ans = Math.max(ans, dfs(i));
            } else {
                break;
            }
        }
        int temp = ans + 1;
        dp[startIndex] = Math.max(dp[startIndex], temp);
        return temp;
    }

    public static void main(String[] args) {
        Solution1340 solution1340 = new Solution1340();
        //[22,29,52,97,29,75,78,2,92,70,90,12,43,17,97,18,58,100,41,32]
        int ans = solution1340.maxJumps(new int[]{22, 29, 52, 97, 29, 75, 78, 2, 92, 70, 90, 12, 43, 17, 97, 18, 58, 100, 41, 32}, 17);
        System.out.println(ans);
    }
}
