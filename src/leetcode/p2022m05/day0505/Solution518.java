package leetcode.p2022m05.day0505;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 9:00 PM
 */
public class Solution518 {
    public int change(int amount, int[] coins) {
        return dfs(amount,0,coins,0,new ArrayList<>());
    }

    private int dfs(final int amount, int sum, final int[] coins, int index, List<Integer> selected) {
        if (sum == amount) {
            System.out.println(selected);
            return 1;
        }
        if (sum > amount) {
            return 0;
        }

        int ans = 0;
        for (int i = index; i < coins.length; i++) {
            selected.add(coins[i]);
            ans += dfs(amount, sum + coins[i], coins, i, selected);
            selected.remove(selected.size() - 1);
        }
        return ans;
    }

    public static void main(String[] args){
        Solution518 solution518=new Solution518();
        int ans=solution518.change(5,new int[]{1,2,5});
        System.out.println(ans);
    }
}
