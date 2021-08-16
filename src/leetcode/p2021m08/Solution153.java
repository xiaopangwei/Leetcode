package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/9
 * @time 11:41 PM
 */
public class Solution153 {
    public int findMin(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }
        int left  = 0;
        int right = nums.length - 1;

        int target = nums[0];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= nums[left] && nums[mid] <= nums[right]) {
                target = nums[left];
                break;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }

        return target;
    }

    public static void main(String[] args){
        Solution153 solution153=new Solution153();
        int ans=solution153.findMin(new int[]{2,1});
        System.out.println(ans);
    }
}
