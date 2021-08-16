package leetcode.p20210216;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution283 {
    public void moveZeroes(int[] nums) {

        int nonZeroCount=0;

        int zeroCount=0;



       for (int i=nums.length-1;i>=0;i--){
           if (nums[i]!=0){

               //swap(i,倒数第zeroCount个元素)
               int j=nums.length-nonZeroCount-1;
               swap(nums,i,j);

               nonZeroCount++;
           }

           else{
               zeroCount++;
           }
       }



    }



    public void swap(int[] number,int i,int j){

//        System.out.println("-->i:"+i+",j:"+j);
        int temp=number[i];
        number[i]=number[j];
        number[j]=temp;
    }


    public static void main(String[] args) throws Exception{

        Solution283 solution283=new Solution283();
        int[] array=new int[]{4,0,0,8,0};
        solution283.moveZeroes(array);
        System.out.println(Arrays.toString(array));


    }
}
