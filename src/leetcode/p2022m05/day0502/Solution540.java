package leetcode.p2022m05.day0502;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 5:24 PM
 */
public class Solution540 {

    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left  = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid-1>=0 && nums[mid] == nums[mid - 1]) {
                int leftLen = mid - left - 1;
                if (leftLen % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = mid - 2;
                }
            } else if (mid+1<nums.length && nums[mid] == nums[mid + 1]) {
                int rightLen = right - mid - 1;
                if (rightLen % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = mid + 2;
                }

            } else {
                return nums[mid];
            }

        }
        return nums[left];
    }
    public static void main(String[] args) {
        int[]       array       = new int[]{1,1,2};
        Solution540 solution540 = new Solution540();
        int         val         = solution540.singleNonDuplicate(array);
        System.out.println(val);
    }
}
