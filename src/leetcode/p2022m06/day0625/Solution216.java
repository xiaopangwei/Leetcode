package leetcode.p2022m06.day0625;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/25
 * @time 2:45 PM
 */
public class Solution216 {
    int k;
    int n;
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(1, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(int startVal, List<Integer> list, int currentSum) {
        if (currentSum > n) {
            return;
        }
        if (list.size() == k) {
            if (currentSum == n) {
                List<Integer> temp = new ArrayList<>(list);
                ans.add(temp);
            }
            return;
        }
        if (startVal > 9) {
            return;
        }

        list.add(startVal);
        dfs(startVal + 1, list, currentSum + startVal);
        list.remove(list.size() - 1);

        dfs(startVal + 1, list, currentSum);
    }

    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        // 1 9
//        10*9/2
        System.out.println(solution216.combinationSum3(9, 45));
    }

}
