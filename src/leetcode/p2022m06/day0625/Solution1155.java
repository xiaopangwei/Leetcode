package leetcode.p2022m06.day0625;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/25
 * @time 3:34 PM
 */
public class Solution1155 {
    int k, n, target;

    public int numRollsToTarget(int n, int k, int target) {
        this.k = k;
        this.n = n;
        this.target = target;
        return dfs(0, 0);
    }

    private int dfs(int index, int currentSum) {
//        System.out.println(index+" "+currentSum);
        if (currentSum > target) {
            return 0;
        }
        if (index >= n) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans += dfs(index + 1, currentSum + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1155 solution1155 = new Solution1155();
        int          ans          = solution1155.numRollsToTarget(2, 6, 7);
        System.out.println(ans);
    }
}
