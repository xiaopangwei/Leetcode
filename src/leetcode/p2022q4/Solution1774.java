package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/4
 * @time 9:17 PM
 */
public class Solution1774 {
    int minGap  = Integer.MAX_VALUE;
    int ansCost = -1;
    int target;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

        this.target = target;
        for (int i = 0; i < baseCosts.length; i++) {
            int cost = baseCosts[i];
            dfs(toppingCosts, 0, cost);
        }
        return ansCost;
    }

    private void dfs(int[] toppingCosts, int index, int sum) {
        if (sum > target) {
            return;
        }
        if (index == toppingCosts.length) {
            if (Math.abs(target - sum) < minGap) {
                minGap = Math.abs(target - sum);
                ansCost = sum;
            } else if (Math.abs(target - sum) == minGap && sum < ansCost) {
                ansCost = sum;
            }
            return;
        }
        for (int i = 0; i <= 2; i++) {
            dfs(toppingCosts, index + 1, sum + i * toppingCosts[index]);
        }
    }

    public static void main(String[] args) {
        Solution1774 solution1774 = new Solution1774();
        System.out.println(solution1774.closestCost(new int[]{1,7}, new int[]{3, 4}, 10));
    }
}
