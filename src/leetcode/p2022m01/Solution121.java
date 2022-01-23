package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/20
 * @time 10:37 PM
 */
public class Solution121 {
    int maxProfit = 0;

    public int maxProfit(int[] prices) {

        dfs(prices, 0, new ArrayList<>());
        return maxProfit;
    }

    private void dfs(int[] prices, int index, List<Integer> temp) {
        if (temp.size() == 2) {
            maxProfit = Math.max(maxProfit, temp.get(0) + temp.get(1));
            return;
        }
        if (index == prices.length) {
            return;
        }
        dfs(prices, index + 1, temp);

        if (temp.size() % 2 == 0) {
            temp.add(-prices[index]);
        } else {
            temp.add(prices[index]);
        }

        dfs(prices, index + 1, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int         max         = solution121.maxProfit(new int[]{7, 6,4,3,1});
        System.out.println(max);
    }
}
