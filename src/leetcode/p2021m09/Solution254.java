package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 10:18 PM
 */
public class Solution254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 1) {
            return ans;
        }
        dfs(n, 2, new ArrayList<>(), ans, n);
        return ans;
    }

    private void dfs(int n, int start, List<Integer> current, List<List<Integer>> ans, final int maxVal) {
        if (n == 1) {
            if (current.size() > 1) {
                List<Integer> temp = new ArrayList<>(current);
                ans.add(temp);
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                current.add(i);
                dfs(n / i, i, current, ans, maxVal);
                current.remove(current.size() - 1);

            }
        }
    }

    public static void main(String[] args) {
        Solution254 solution254 = new Solution254();
        System.out.println(solution254.getFactors(2));
    }
}
