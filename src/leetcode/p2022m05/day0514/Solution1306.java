package leetcode.p2022m05.day0514;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 11:32 PM
 */
public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (start < 0 || start >= arr.length || visited[start]) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        visited[start] = true;
        boolean flag = dfs(arr, start + arr[start], visited) || dfs(arr, start - arr[start], visited);
        if (flag) {
            return true;
        }
        visited[start] = false;
        return false;

    }

    public static void main(String[] args) {
        int[]        array        = new int[]{3, 0, 2, 1, 2};
        Solution1306 solution1306 = new Solution1306();
        boolean      ans          = solution1306.canReach(array, 2);
        System.out.println(ans);
    }
}
