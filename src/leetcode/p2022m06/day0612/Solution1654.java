package leetcode.p2022m06.day0612;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/21
 * @time 9:50 PM
 */
public class Solution1654 {
    List<Integer> forbidList;
    int           a;
    int           b;

    public int minimumJumps(int[] forbidden, int a, int b, int x) {

        forbidList = new ArrayList<>();
        for (int item : forbidden) {
            forbidList.add(item);
        }
        this.a = a;
        this.b = b;
        boolean[][] visited = new boolean[1000][2];
        int         ans     = dfs(visited, x, 0, 0, new ArrayList<>());
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    private int dfs(boolean[][] visited, final int target, int x, int backSkipContinuousCount, List<Integer> list) {
        if (x == target) {
            System.out.println(list);
            return 0;
        }
        if (x > visited.length) {
            return Integer.MAX_VALUE;
        }
        //向前
        int frontX = x + a;
        int ans    = Integer.MAX_VALUE;
        if (frontX < visited.length && !visited[frontX][0] && !forbidList.contains(frontX)) {
            visited[frontX][0] = true;
            list.add(frontX);
            int t1 = dfs(visited, target, frontX, 0, list);
            list.remove(list.size() - 1);
            if (t1 == Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
            } else {
                ans = Math.min(ans, t1 + 1);
            }
//            visited[frontX][0] = false;
        }
        //向后
        int backX = x - b;
        if (backX >= 0 && !visited[backX][1] && !forbidList.contains(backX) && backSkipContinuousCount == 0) {
            visited[backX][1] = true;
            list.add(backX);
            int t2 = dfs(visited, target, backX, 1, list);
            list.remove(list.size() - 1);
            if (t2 == Integer.MAX_VALUE) {
                ans = Integer.MAX_VALUE;
            } else {
                ans = Math.min(ans, t2 + 1);
            }
//            visited[backX][1] = false;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[]        forbidden    = new int[]{1,6,2,14,5,17,4};
        Solution1654 solution1654 = new Solution1654();
        int          ans          = solution1654.minimumJumps(forbidden, 16, 9, 7);
        System.out.println(ans);
    }
}
