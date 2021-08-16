package leetcode.p20210703;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/4
 * @time 11:31 PM
 */
public class Solution645 {
    public int[] findErrorNums(int[] nums) {

        Arrays.sort(nums);
        int n=nums.length;
        int sum=(1+n)*n/2;

        int index=0;
        int duplicated=0;
        while (index<n)
        {
            if (index>0 && nums[index]==nums[index-1])
            {
                duplicated=nums[index];
                break;
            }

            index++;
        }

        int sum2=0;
        for (int i=0;i<nums.length;i++){
            sum2+=nums[i];
        }
        int gap=sum-sum2;

        int loss=duplicated+gap;

        return new int[]{duplicated,loss};
    }


    public static void main(String[] args){
        Solution645 solution645=new Solution645();
        int[] array=solution645.findErrorNums(new int[]{1,2,4,4});
        System.out.println(array[0]+" "+array[1]);
    }
}
