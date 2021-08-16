package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/24
 * @time 3:08 PM
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {

        int[] copy=new int[nums.length];
        System.arraycopy(nums,0,copy,0,nums.length);
        Arrays.sort(copy);

        int idx1=nums.length/2-1;
        if (nums.length%2!=0){
            idx1=nums.length/2;
        }
        int idx2=nums.length-1;
        int k=0;

        while (idx1>=0){
            nums[k]=copy[idx1--];
            System.out.println(k+" "+nums[k]);
            k+=2;
        }
        k=1;
        while (idx2>=nums.length/2 && k<nums.length){
            nums[k]=copy[idx2--];
            System.out.println(k+" "+nums[k]);
            k+=2;
        }

    }

    public static void main(String[] args){

        int[] array=new int[]{1,2,3,4};
        Solution324 solution324=new Solution324();
        solution324.wiggleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
