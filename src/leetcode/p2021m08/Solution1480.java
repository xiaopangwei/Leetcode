package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/28
 * @time 5:13 PM
 */
public class Solution1480 {
    public int[] runningSum(int[] nums) {

        int[] res=new int[nums.length];
        res[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            res[i]=res[i-1]+nums[i];
        }

        return res;
    }

    public static void main(String[] args){
        Solution1480 solution1480=new Solution1480();
        int[] arr=solution1480.runningSum(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(arr));
    }
}
