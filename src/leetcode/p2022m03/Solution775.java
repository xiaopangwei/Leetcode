package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/16
 * @time 10:15 PM
 */
public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] > nums[i + 1]) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                i += 2;
            } else {
                i += 1;
            }
        }
        System.out.println(Arrays.toString(nums));
        int max=nums[0];
        for (int j=1;j<nums.length;j++){
            if (nums[j]>max){
                max=nums[j];
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution775 solution775=new Solution775();
        boolean ans=solution775.isIdealPermutation(new int[]{11,12,10,13,8});
        System.out.println(ans);
    }
}
