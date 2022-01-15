package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 4:09 PM
 */
public class Solution60 {

    int[] permutation;
    String ans = null;
    boolean[] visited;
    int       k;

    public String getPermutation(int n, int k) {
        this.k = k;
        permutation = new int[n + 1];
        visited = new boolean[n + 1];
        permutation[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            permutation[i] = permutation[i - 1] * i;
        }

        dfs(0, new ArrayList<>(), n);
        return ans;
    }


    private void dfs(int index, List<String> list, final int n) {
        if (index == n) {
            ans = String.join("", list);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            int count = permutation[n -1-index];
            if (count < k) {
                k -= count;
                continue;
            }
            visited[i] = true;
            list.add(String.valueOf(i));
            dfs(index + 1, list, n);
        }
    }

    public static void main(String[] args) {
        Solution60 solution60 = new Solution60();
        String     ans        = solution60.getPermutation(3, 1);
        System.out.println(ans);
    }
}
