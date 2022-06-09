package leetcode.p2022m06.day0601;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/1
 * @time 8:28 PM
 */
public class Solution473 {
    int[]     matchsticks;
    boolean[] visited;

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }
        this.matchsticks = matchsticks;
        visited = new boolean[matchsticks.length];
        int sum    = 0;
        int maxVal = matchsticks[0];
        for (int m : matchsticks) {
            sum += m;
            maxVal = Math.max(maxVal, m);
        }

        Arrays.sort(matchsticks);

        int avg = sum / 4;
        if (sum % 4 != 0 || maxVal > avg) {
            return false;
        }
        return dfs(0, 0, avg, 0);
    }

    private boolean dfs(int count, int currentSum, final int targetSum, int startIndex) {

        if (count == 4) {
            return true;
        }
        if (currentSum > targetSum) {
            return false;
        }
        if (currentSum == targetSum) {
            return dfs(count + 1, 0, targetSum, 0);
        }

        for (int i = startIndex; i < matchsticks.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (currentSum + matchsticks[i] > targetSum) {
                break;
            }
            visited[i] = true;
            boolean flag = dfs(count, currentSum + matchsticks[i], targetSum, i + 1);
            if (flag) {
                return true;
            }
            visited[i] = false;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution473 solution473 = new Solution473();
        boolean     flag        = solution473.makesquare(new int[]{1,1,2,2,2});
        System.out.println(flag);
    }
}
