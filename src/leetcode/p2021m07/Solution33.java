package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 4:13 PM
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (target==nums[mid]){
                return mid;
            }
            if (nums[mid]>=nums[left]){
                if (target<nums[mid] && target>=nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            else {
                if (target>nums[mid] && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args){
        Solution33 solution33=new Solution33();
        int ans=-1;
        ans=solution33.search(new int[]{1,3},3);
        System.out.println(ans);


        ans=solution33.search(new int[]{1,3},1);
        System.out.println(ans);


        ans=solution33.search(new int[]{5,1,3},5);
        System.out.println(ans);

        ans=solution33.search(new int[]{6,7,1,2,3,4,5},6);
        System.out.println(ans);

        ans=solution33.search(new int[]{4,5,6,7,0,1,2},3);
        System.out.println(ans);

        ans=solution33.search(new int[]{4,5,6,7,8,1,2,3},8);
        System.out.println(ans);

    }
}
