package leetcode.p2022m01;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 10:51 PM
 */
public class Solution1690 {
    int[][] cached;

    public int stoneGameVII(int[] stones) {
        int s = 0;
        cached = new int[stones.length][stones.length];
        for (int i = 0; i < stones.length; i++) {
            Arrays.fill(stones, -1);
        }
        for (int item : stones) {
            s += item;
        }
        return dfs(stones, 0, stones.length - 1, s);
    }

    private int dfs(int[] stone, int left, int right, int sum) {
        if (cached[left][right] != -1) {
            return cached[left][right];
        }
        if (left == right) {
            cached[left][right] = 0;
            return 0;
        }
        int a = 0;
        int b = 0;
        //先手左边
        a = sum - stone[left];
        b = dfs(stone, left + 1, right, sum - stone[left]);
        int t1 = a - b;
        //先手右边
        a = sum - stone[right];
        b = dfs(stone, left, right - 1, sum - stone[right]);
        int t2  = a - b;
        int ans = Math.max(t1, t2);
        cached[left][right] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[]        array        = new int[]{7, 90, 5, 1, 100, 10, 10, 2};
        Solution1690 solution1690 = new Solution1690();
        int          max          = solution1690.stoneGameVII(array);
        System.out.println(max);

    }
}
