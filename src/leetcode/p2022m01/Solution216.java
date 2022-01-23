package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/19
 * @time 8:54 PM
 */
public class Solution216 {
    int k;
    int n;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(0, 0, new ArrayList<>(), 1);
        return res;
    }

    private void dfs(int index, int currentSum, List<Integer> temp, int startIndex) {
        if (index == k) {
            if (currentSum == n) {
                res.add(new ArrayList<>(temp));

            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            if (currentSum + i > n) {
                break;
            }
            temp.add(i);
            dfs(index + 1, currentSum + i, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution216         solution216 = new Solution216();
        List<List<Integer>> ans         = solution216.combinationSum3(3, 9);
        System.out.println(ans);
    }
}
