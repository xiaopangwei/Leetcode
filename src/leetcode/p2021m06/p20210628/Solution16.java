package leetcode.p2021m06.p20210628;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 3:10 PM
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        int closedSum=0;
        int gap=Integer.MAX_VALUE;

        for (int i=0;i<nums.length;i++){
            int current=nums[i];
            start=i+1;
            end=nums.length-1;

            while (start<nums.length && end>=0 && start<end){
                int sum=nums[start]+current+nums[end];
                System.out.println(nums[start]+" "+current+" "+nums[end]);
                if (sum==target){
                    return target;
                }else if(sum<target){
                    start++;
                    if (target-sum<gap){
                        gap=target-sum;
                        closedSum=sum;
                    }
                }else{
                    end--;
                    if (sum-target<gap){
                        gap=sum-target;
                        closedSum=sum;
                    }
                }
            }
        }
        return closedSum;
    }

    public static void main(String[] args){
        Solution16 solution16=new Solution16();
        System.out.println(solution16.threeSumClosest(new int[]{0,2,1,-3},1));
    }
}
