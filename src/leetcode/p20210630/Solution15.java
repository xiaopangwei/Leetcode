package leetcode.p20210630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 4:33 PM
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int pivot=i;
            int left=pivot+1;
            int right=nums.length-1;
            while (left<right ){
                if (nums[left]+nums[right]+nums[pivot]==0){
                    result.add(Arrays.asList(nums[pivot],nums[left],nums[right]));
                    while (left<right && nums[left]==nums[left+1]) {left++;}
                    left++;
                    while (left<right && nums[right]==nums[right-1]) {right--;}
                    right--;

                }else if (nums[left]+nums[right]+nums[pivot]<0){
                     left++;
                }else {
                     right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Solution15 solution15=new Solution15();
        List<List<Integer>> ans=solution15.threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(ans);
    }
}
