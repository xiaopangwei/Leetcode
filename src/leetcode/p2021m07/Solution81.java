package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 5:13 PM
 */
public class Solution81 {
    //[0,1,2,4,4,4,5,6,6,7]
    //[4,5,6,6,7,0,1,2,4,4]
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return true;
            }
            else{
                if (nums[left]==nums[right] && nums[left]==nums[mid]){
                    left++;
                    right--;
                }else{
                    if (nums[mid]>=nums[left]){
                        if (nums[left]<=target && target<=nums[mid]){
                            right=mid-1;
                        }else{
                            left=mid+1;
                        }
                    }else{
                        if (nums[mid]<=target && target<=nums[right]){
                            left=mid+1;
                        }else{
                            right=mid-1;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        Solution81 solution81=new Solution81();
        int[] array=new int[]{4,5,6,6,7,0,1,2,4,4};

        for (int i=0;i<10;i++){
            System.out.println("i:"+i+" "+solution81.search(array,i));
        }
    }
}
