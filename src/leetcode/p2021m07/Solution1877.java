package leetcode.p2021m07;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/20
 * @time 5:23 PM
 */
public class Solution1877 {
    public int minPairSum(int[] nums) {

        Arrays.sort(nums);
        int start=0;
        int end=nums.length-1;
        int maxVal=0;
        while (start<end){
            maxVal=Math.max(maxVal,nums[start]+nums[end]);
            start++;
            end--;
        }

        return maxVal;
    }

    public static void main(String[] args){
        Solution1877 solution1877=new Solution1877();
        int res=solution1877.minPairSum(new int[]{3,5,2,3});
        System.out.println(res);
    }
}
