package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 4:03 PM
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;
        int i=m-1;
        int j=n-1;

        while (i>=0 && j>=0){
            if (nums2[j]>nums1[i]){
                nums1[k--]=nums2[j];
                j--;
            }else if (nums2[j]<nums1[i]){
                nums1[k--]=nums1[i];
                i--;
            }else{
                nums1[k--]=nums1[i];
                nums1[k--]=nums2[j];

                i--;
                j--;
            }
        }

        if (j>=0){
            System.arraycopy(nums2,0,nums1,0,j+1);
        }
    }

    public static void main(String[] args){
        Solution88 solution88=new Solution88();
        int[] array=new int[]{1,5,25,0,0,0};
        solution88.merge(array,3,new int[]{10,20,30},3);
        System.out.println(Arrays.toString(array));
    }
}
