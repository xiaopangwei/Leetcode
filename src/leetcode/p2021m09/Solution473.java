package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/22
 * @time 9:17 PM
 */
public class Solution473 {
    int avg;

    public boolean makesquare(int[] matchsticks) {

        Arrays.sort(matchsticks);

        int sum = 0;
        for (int item : matchsticks) {
            sum += item;
        }

        if (sum % 4 != 0) {
            return false;
        }

        this.avg = sum / 4;
        if (matchsticks[matchsticks.length - 1] > avg) {
            return false;
        }

        if (matchsticks[matchsticks.length - 1] < avg &&
                matchsticks[0] + matchsticks[matchsticks.length - 1] > avg) {
            return false;
        }
        boolean[]           visited = new boolean[matchsticks.length];
        List<List<Integer>> data    = new ArrayList<>();
        boolean             ans     = dfs(matchsticks, visited, 0, 0, new ArrayList<>(), data);
        return ans;
    }

    private boolean dfs(final int[] matchsticks, boolean[] visited, int currentSum, int round, List<Integer> tmp, List<List<Integer>> data) {

        if (round == 4) {
            System.out.println(data);
            return true;
        }
        if (currentSum == this.avg) {
            List<Integer> copy = new ArrayList<>(tmp);
            System.out.println(copy);
            data.add(copy);
            boolean res = dfs(matchsticks, visited, 0, round + 1, new ArrayList<>(), data);
            data.remove(data.size() - 1);
            return res;
        }
        for (int i = 0; i < matchsticks.length; i++) {
            if (currentSum + matchsticks[i] > avg) {
                break;
            }
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(matchsticks[i]);
                if (dfs(matchsticks, visited, currentSum + matchsticks[i], round, tmp, data)) {
                    return true;
                }
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
        return false;

    }


    public static void main(String[] args) {
        Solution473 solution473 = new Solution473();
        //5,5,5,5,4,4,4,4,3,3,3,3
        //5,5,5,5,16,4,4,4,4,4,3,3,3,3,4
        boolean ans = solution473.makesquare(new int[]{5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4});
        System.out.println(ans);
    }
}
