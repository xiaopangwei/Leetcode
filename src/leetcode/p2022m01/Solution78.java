package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/16
 * @time 10:55 AM
 */
public class Solution78 {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0,new ArrayList<>());
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> temp) {
        if (index == nums.length) {
            List<Integer> t = new ArrayList<>(temp);
            ans.add(t);
            return;
        }

        dfs(nums, index + 1, temp);
        temp.add(nums[index]);
        dfs(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args){
        Solution78 solution78=new Solution78();
        List<List<Integer>> ans=solution78.subsets(new int[]{1,2,3});
        System.out.println(ans);
    }
}
