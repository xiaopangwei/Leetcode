package leetcode.p2021m06.p20210630;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 3:40 PM
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
       return search(nums,0,nums.length-1,target);
    }

    private int search(int[] nums,int s,int e, int target){
       int left=s;
       int right=e;

       while (left<=right){
           int mid=left+(right-left)/2;
           if (nums[mid]==target){
               return mid;
           }else if (nums[mid]<target){
               left=mid+1;
           }
           else{
               right=mid-1;
           }
       }

       return left;
    }


    public static void main(String[] args){
        Solution35 solution35=new Solution35();
        System.out.println(solution35.searchInsert(new int[]{1,3,5,6},0));
    }
}
