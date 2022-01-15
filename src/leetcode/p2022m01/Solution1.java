package leetcode.p2022m01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 10:11 AM
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map =new HashMap<>();
        int[]                ans =new int[2];
        for(int i=0;i<nums.length;i++){
            int temp=target-nums[i];
            if(map.containsKey(temp) && map.get(temp)!=i){
                ans[0]=i;
                ans[1]=map.get(temp);
                break;
            }
            map.put(nums[i],i);
        }


        return ans;
    }

    public static void main(String[] args){
        Solution1 solution1=new Solution1();
        int[] ans=solution1.twoSum(new int[]{3,3},6);
        System.out.println(Arrays.toString(ans));
    }
}
