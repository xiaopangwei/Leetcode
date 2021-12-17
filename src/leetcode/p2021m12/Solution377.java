package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/8
 * @time 9:12 PM
 */
public class Solution377 {
    Map<Integer,Integer> cache=new HashMap<>();
    public int combinationSum4(int[] nums, int target) {

        if (cache.containsKey(target)){
            return cache.get(target);
        }
        if (target==0){
            return 1;
        }
        if (target<0){
            return 0;
        }
        int ans=0;
        for (int item:nums){
            ans+=combinationSum4(nums,target-item);
        }

        cache.put(target,ans);
        return ans;
    }

    public static void main(String[] args){
        Solution377 solution377=new Solution377();
        int ans=solution377.combinationSum4(new int[]{9},3);
        System.out.println(ans);
    }
}
