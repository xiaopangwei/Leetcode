package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/16
 * @time 10:27 AM
 */
public class Solution526 {
    int cnt = 0;

    public int countArrangement(int n) {

        if (n <= 1) {
            return n;
        }
        //0~n-1
        boolean[] visited = new boolean[n];
        dfs(visited, new ArrayList<>(), n);
        return cnt;
    }

    private void dfs(boolean[] visited, List<Integer> ans, int n) {
        if (ans.size() == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int idx     = ans.size() + 1;
                int digit   = i + 1;
                int bigger  = Math.max(idx, digit);
                int smaller = Math.min(idx, digit);
                if (bigger % smaller != 0) {
                    continue;
                }
                ans.add(i + 1);
                visited[i] = true;
                dfs(visited, ans, n);
                ans.remove(ans.size() - 1);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        Solution526 solution526 = new Solution526();
        int         ans         = solution526.countArrangement(15);
        System.out.println(ans);
    }
}
