package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 5:35 PM
 */
public class Solution547 {
    public int findCircleNum(int[][] isConnected) {

        int       ans     = 0;
        int       length  = isConnected.length;
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                ans++;
                dfs(isConnected, i, visited);
            }
        }
        return ans;
    }

    private void dfs(int[][] isConnected, int startIndex, boolean[] visited) {
        int length = isConnected.length;
        for (int i = 0; i < length; i++) {
            if (i == startIndex || visited[i] || isConnected[startIndex][i] == 0) {
                continue;
            }
            visited[i] = true;
            dfs(isConnected, i, visited);
        }
    }

    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();

        int[][] array = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

        int ans = solution547.findCircleNum(array);

        System.out.println(ans);

    }
}
