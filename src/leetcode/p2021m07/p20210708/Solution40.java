package leetcode.p2021m07.p20210708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/6
 * @time 10:45 AM
 */
public class Solution40 {
    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        System.out.println(Arrays.toString(candidates));
        visited = new boolean[candidates.length];
        List<Integer> dataList = new ArrayList<>();
        dfs(dataList, candidates, target, 0, 0);

        return res;
    }


    private void dfs(List<Integer> list, int[] candidates, final int target, int currentSum, int start) {
        if (currentSum > target) {
            return;
        }
        if (currentSum == target) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (candidates[i] + currentSum > target) {
                break;
            }
            list.add(candidates[i]);
            visited[i] = true;
            dfs(list, candidates, target, currentSum + candidates[i], i + 1);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution40          solution40 = new Solution40();
        List<List<Integer>> res        = solution40.combinationSum2(new int[]{2,5,2,1,2}, 5);
        System.out.println(res);
    }
}
