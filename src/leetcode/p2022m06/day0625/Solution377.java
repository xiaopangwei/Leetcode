package leetcode.p2022m06.day0625;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/25
 * @time 2:57 PM
 */
public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        dfs(nums,target,0,new ArrayList<>());
        return 0;
    }

    //nums = [1,2,3], target = 4
    private void dfs(int[] nums, int remained, int index, List<Integer> list) {
        if (index >= nums.length) {
            return;
        }
        if (remained < 0) {
            return;
        }
        if (remained == 0) {
            System.out.println(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, remained - nums[i], i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Solution377 solution377=new Solution377();
        int ans=solution377.combinationSum4(new int[]{1,2,3},4);
        System.out.println(ans);
    }
}
