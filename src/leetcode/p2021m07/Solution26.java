package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 4:16 PM
 */
public class Solution26 {
    public int removeDuplicates(int[] nums) {

        int idx=0;
        int len=nums.length;
        int distinctCount=0;
        while(true){
           int target=nums[distinctCount++];
           while (idx<len && nums[idx]==target){idx++;}
           if (idx<len){
               nums[distinctCount]=nums[idx];
           }else {
               break;
           }
        }
        return distinctCount;
    }

    public static void main(String[] args){
        Solution26 solution26=new Solution26();
        int[] array=new int[]{0,0,1,1,3,4,4};
        int num=solution26.removeDuplicates(array);
        System.out.println(num);
        System.out.println(Arrays.toString(array));
    }
}
