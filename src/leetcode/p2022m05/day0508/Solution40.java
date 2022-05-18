package leetcode.p2022m05.day0508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 7:52 PM
 */
public class Solution40 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        visited = new boolean[candidates.length];

        dfs(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(final int[] candidates, final int target, int currentSum, int index, List<Integer> selected) {
        if (currentSum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(selected);
            ans.add(temp);
        }
        if (currentSum > target) {
            return;
        }

        if (index >= candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            selected.add(candidates[i]);
            dfs(candidates, target, currentSum + candidates[i], i + 1, selected);
            selected.remove(selected.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        System.out.println(solution40.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
