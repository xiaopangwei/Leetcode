package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/20
 * @time 4:53 PM
 */
public class Solution1838 {
    public int maxFrequency(int[] nums, int k) {

        if (nums.length<=1){
            return nums.length;
        }
        int max=0;

        Arrays.sort(nums);

        int[] sumArray=new int[nums.length];
        sumArray[0]=nums[0];
        for (int i=1;i<nums.length;i++){
            sumArray[i]=sumArray[i-1]+nums[i];
        }

        int left=0;
        int right=1;

        while (right<nums.length){

            //a[left]...a[right]
            int gap=getSumGap(nums,left,right,sumArray);
            if (gap<=k){
                max=Math.max(max,right-left+1);
            }else{
                while (left<right){
                    int sum=gap-nums[left++];
                    if (sum<=k){
                        break;
                    }
                }
                max=Math.max(max,right-left+1);
            }
            right++;
        }

        return max;
    }

    private int getSumGap(int[] array,int start,int end,int[] sumArray){
        int width=end-start+1;
        int sum=0;
        if (start>=1) {
            sum=sumArray[end] - sumArray[start - 1];
        }else{
            sum=sumArray[end];
        }
        return array[end]*width-sum;
    }

    public static void main(String[] args){
        Solution1838 solution1838=new Solution1838();
        System.out.println(solution1838.maxFrequency(new int[]{1,4,8,13},5));
        System.out.println(solution1838.maxFrequency(new int[]{1,2,4},5));
        System.out.println(solution1838.maxFrequency(new int[]{1,2,3,4,5},10));
    }
}
