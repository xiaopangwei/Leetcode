package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/17
 * @time 9:51 PM
 */
public class Solution47 {

    List<List<Integer>> ans = new ArrayList<>();

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited = new boolean[nums.length];

        dfs(nums, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int depth, List<Integer> temp) {

        if (depth == nums.length) {
            System.out.println(temp);
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            if (i >= 1 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            visited[i] = true;
            dfs(nums, depth+1, temp);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }

    }

    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        System.out.println(solution47.permuteUnique(new int[]{1, 2, 1}));
    }
}
