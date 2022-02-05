package leetcode.p2021m02.p20210223;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/23
 * @time 11:22 AM
 */
public class Solution39 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<Integer> dataList = new ArrayList<>();
        dfs(dataList, candidates, target, 0, 0);
        System.out.println(res.size());
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
            if (candidates[i] + currentSum > target) {
                break;
            }
            list.add(candidates[i]);
            dfs(list, candidates, target, currentSum + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution39 solution77 = new Solution39();
        int[]      array      = new int[]{2,3,6,7};
        Arrays.sort(array);
        List<List<Integer>> ans = solution77.combinationSum(array, 7);
        System.out.println(ans);

    }
}
