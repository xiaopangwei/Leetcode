package leetcode.p20210629;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 10:00 PM
 */
public class Solution34
{
    public static void main(String[] args){
        Solution34 solution34=new Solution34();
        System.out.println(solution34.searchRange(new int[]{1,3,3,3,3,3,3,7},3));
    }

    public int[] searchRange(int[] nums, int target) {
        int minIndex=this.getMinIndex(nums,target);
        int maxIndex=this.getMaxIndex(nums,target);
        System.out.println(minIndex+" "+maxIndex);
        return new int[]{minIndex,maxIndex};
    }

    private int getMinIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        boolean flag=false;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }else{
                flag=true;
                if (mid-1>=0){
                    if (nums[mid-1]==nums[mid]){
                        right=mid-1;
                    }else{
                        return mid;
                    }
                }else{
                    return 0;
                }
            }
        }
        if (flag){
            return left;
        }else{
             return -1;
        }
    }


    private int getMaxIndex(int[] nums, int target){
        int left=0;
        int right=nums.length-1;
        boolean flag=false;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<target){
                left=mid+1;
            }else if (nums[mid]>target){
                right=mid-1;
            }else{
                flag=true;
                if (mid+1<=nums.length-1){
                    if (nums[mid+1]==nums[mid]){
                        left=mid+1;
                    }else{
                       return mid;
                    }
                }else{
                    return nums.length-1;
                }
            }
        }
        if (flag){
            return left;
        }else{
            return -1;
        }
    }
}
