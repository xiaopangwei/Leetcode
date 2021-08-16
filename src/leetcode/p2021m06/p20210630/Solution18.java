package leetcode.p2021m06.p20210630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 9:06 PM
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        List<List<Integer>> ans=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<nums.length;j++){
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=nums.length-1;
                while (left<right)
                {
                    int sum=nums[left]+nums[i]+nums[j]+nums[right];
                    if (sum==target){
                        ans.add(Arrays.asList(nums[i],nums [j],nums[left],nums[right]));
                        while (left<right && nums[left]==nums[left+1] ){left++;}
                        left++;
                        while (left<right && nums[right]==nums[right-1] ){right--;}
                        right--;
                    }else if (sum<target){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }

        return ans;
    }



    public static void main(String[] args){
        int[] array=new int[]{2,2,2,2,2};
        Solution18 solution18=new Solution18();
        System.out.println(solution18.fourSum(array,8));
    }
}
