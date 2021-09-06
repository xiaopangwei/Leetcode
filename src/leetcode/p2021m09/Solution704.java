package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/6
 * @time 11:34 AM
 */
public class Solution704 {
    public int search(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }

        return -1;
    }
}
