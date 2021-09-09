package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/8
 * @time 9:04 PM
 */
public class Solution1273 {


    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] total = value.clone();
        int   i     = total.length - 1;
        int[] cnt   = new int[nodes];
        Arrays.fill(cnt, 1);
        while (i > 0) {
            int index = parent[i];
            total[index] += total[i];
            if (total[index] != 0) {
                cnt[index] += cnt[i];
            }
            i--;
        }

        int sum = 0;
        for (int val : value) {
            sum += val;
        }

        if (sum == 0) {
            return 0;
        }

        return cnt[0];


    }

    private void dfs(int index, int[] parent, boolean[] visited) {
        visited[index] = true;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == index) {
                dfs(i, parent, visited);
            }
        }
    }

    public static void main(String[] args) {
        Solution1273 solution1273 = new Solution1273();
        int ans = solution1273.deleteTreeNodes(38,
                new int[]{-1, 7, 0, 2, 22, 25, 2, 0, 7, 14, 25, 22, 25, 14, 0, 22, 22, 2, 14, 14, 22, 14, 25, 2, 14, 0, 32, 2, 2, 32, 25, 22, 0, 2, 2, 22, 14, 14},
                new int[]{-95448, -60462, -61595, 68758, 68709, 32611, 22289, -39426, -78078, 91853, -56848, 26101, -87072, -32610, 98615, 22254, -70154, 86962, -93287, 12168, 90664, 49974, -13514, 23360, -12832, -64062, -54784, 73509, 78689, -72481, -338, 81909, -63543, -88910, 65612, 36464, 44448, -29505});
        System.out.println(ans);
    }
}
