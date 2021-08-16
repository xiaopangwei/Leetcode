package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 2:03 PM
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {

        int len=nums.length;
        k=k%len;
        reverse(nums,0,nums.length-1);

        reverse(nums,0,k-1);

        reverse(nums,k,nums.length-1);
    }


    public void reverse(int[] num,int start,int end){

        int i=start;
        int j=end;

        while (i<j){

            int temp=num[i];
            num[i]=num[j];
            num[j]=temp;

            i++;
            j--;
        }
    }


    public static void main(String[] args){
        Solution189 solution189=new Solution189();
        int[] array=new int[]{-1,-100,3,99};
        solution189.rotate(array,2);
        System.out.println(Arrays.toString(array));
    }
}
