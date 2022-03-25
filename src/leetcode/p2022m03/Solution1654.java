package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/20
 * @time 8:53 PM
 */
public class Solution1654 {
    int           a;
    int           b;
    int           target;
    List<Integer> forbid;
    int[][] state = new int[8000][2];

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        for (int i = 0; i < 8000; i++) {
            Arrays.fill(state[i], Integer.MAX_VALUE);
        }
        this.a = a;
        this.b = b;
        this.target = x;
        forbid = new ArrayList<>();
        for (int item : forbidden) {
            forbid.add(item);
        }
        boolean[][] visited = new boolean[8000][2];
        int         ans     = dfs(0, 0, visited);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int dfs(int x, int backCount, boolean[][] visited) {

        if (x == target) {
            return 0;
        }

        if (this.state[x][backCount] != Integer.MAX_VALUE) {
            return this.state[x][backCount];
        }
        int ans = Integer.MAX_VALUE;
        if (x + a < visited.length && !visited[x + a][0] && !forbid.contains(x + a)) {

            visited[x + a][0] = true;
            int temp = dfs(x + a, 0, visited);
            if (temp != Integer.MAX_VALUE) {
                ans = Math.min(temp + 1, ans);
            }

        }
        if (x - b >= 0 && !visited[x - b][1] && !forbid.contains(x - b)
                && backCount < 1) {
            visited[x - b][1] = true;
            backCount++;
            int temp = dfs(x - b, 1, visited);
            if (temp != Integer.MAX_VALUE) {
                ans = Math.min(temp + 1, ans);
            }
        }
        this.state[x][backCount] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution1654 solution1654 = new Solution1654();
        int          ans          = solution1654.minimumJumps(
                new int[]{8,3,16,6,12,20}, 15, 13,11);
        System.out.println(ans);
    }
}
