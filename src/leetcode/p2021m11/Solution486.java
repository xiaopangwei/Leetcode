package leetcode.p2021m11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 11:08 PM
 */
public class Solution486 {

    private Map<String, Integer> cached = new HashMap<>();

    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums, 0, nums.length - 1) >= 0;
    }

    private int dfs(final int[] nums, int start, int end) {
        String key = start + "#" + end;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (start > end) {
            return 0;
        }


        int t1 = nums[start] - dfs(nums, start + 1, end);
        int t2 = nums[end] - dfs(nums, start, end - 1);

        int ans = Math.max(t1, t2);
        cached.put(key, ans);
        return ans;
    }

    public static void main(String[] args){
        Solution486 solution486=new Solution486();
        boolean flag=solution486.PredictTheWinner(new int[]{1,5,233,7});
        System.out.println(flag);
    }
}
