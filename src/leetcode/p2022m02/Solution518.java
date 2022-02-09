package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/9
 * @time 6:57 PM
 */
public class Solution518 {

    int[][] cached;

    public int change(int amount, int[] coins) {

        cached = new int[amount + 1][coins.length + 1];
        for (int i = 0; i < cached.length; i++) {
            Arrays.fill(cached[i], -1);
        }
        return dfs(coins, 0, amount, 0);
    }

    private int dfs(int[] coins, int sum, final int amount, int startIndex) {


        if (sum > amount) {
            return 0;
        }
        if (sum == amount) {
//            System.out.println(list);
            return 1;
        }

        if (startIndex >= coins.length) {
            return 0;
        }
        if (cached[sum][startIndex] != -1) {
            return cached[sum][startIndex];
        }
        int ans = 0;
        for (int i = startIndex; i < coins.length; i++) {
//            list.add(coins[i]);
            ans += dfs(coins, sum + coins[i], amount, i);
//            list.remove(list.size() - 1);
        }
        cached[sum][startIndex] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution518 solution518 = new Solution518();
        int         ans         = solution518.change(5, new int[]{1, 2, 5});
        System.out.println(ans);
    }
}
