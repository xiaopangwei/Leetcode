package leetcode.p2022m05.day0511;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 8:25 PM
 */
public class Solution77 {
    List<List<Integer>> ans = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        boolean[] visited = new boolean[n + 1];
        dfs(visited, new ArrayList<>(), 1);
        return ans;
    }

    public void dfs(boolean[] visited, List<Integer> list, int startVal) {
        if (list.size() == k) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            ans.add(temp);
            return;
        }

        for (int i = startVal; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(i);
            dfs(visited, list, i + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution77 solution77 = new Solution77();
        System.out.println(solution77.combine(4, 2));
    }
}
