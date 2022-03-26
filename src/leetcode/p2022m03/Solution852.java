package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/9
 * @time 9:50 PM
 */
public class Solution852 {
    public int peakIndexInMountainArray(int[] nums) {
        int left  = 1;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;

            }
            //mid+1先判断
            else if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution852 solution852 = new Solution852();
        int         ans         = solution852.peakIndexInMountainArray(new int[]{3, 5, 3, 2, 0});
        System.out.println(ans);
    }
}
