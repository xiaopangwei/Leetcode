package leetcode.p20210312;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/12
 * @time 2:26 PM
 */
public class Solution162 {


    public int findPeakElement(int[] nums) {

        int i=0;
        int j=nums.length-1;
        while (i<j){
            int mid=(i+j)/2;

            if (nums[mid+1]>=nums[mid]){
                i=mid+1;
            }
            else{
                j=mid;

            }
        }
        return i;
    }
    public static void main(String[] args){
        Solution162 solution162=new Solution162();
        int[] array=new int[]{1,2,1};
        System.out.println(solution162.findPeakElement(array));
    }
}
