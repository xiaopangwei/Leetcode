package leetcode.p20210614;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/17
 * @time 10:46 AM
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        int idx=0;
        int maxIndex=nums[idx];
        if (maxIndex>=nums.length-1){
            return true;
        }
        for (int i=1;i<nums.length-1;i++){
            if (maxIndex>=i){
                maxIndex=Math.max(maxIndex,i+nums[i]);
            }

            if (maxIndex>=nums.length-1){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        Solution55 solution55=new Solution55();
        System.out.println(solution55.canJump(new int[]{2,3,1,1,4}));
    }
}
