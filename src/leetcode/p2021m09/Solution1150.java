package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/5
 * @time 10:47 PM
 */
public class Solution1150 {
    public boolean isMajorityElement(int[] nums, int target) {

        int minLen = nums.length / 2;

        int lowerIndex = searchLowerBound(nums, target);
        int upperIndex = searchUpperBound(nums, target);

        if (lowerIndex >= 0 && lowerIndex < nums.length &&
                upperIndex >= 0 && upperIndex <= nums.length) {
            return upperIndex - lowerIndex + 1 > minLen;
        }

        return false;

    }

    private int searchLowerBound(int[] nums, int target) {

        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid - 1 < 0) {
                    return mid;
                } else {
                    if (nums[mid - 1] != nums[mid]) {
                        return mid;
                    } else {
                        right = mid - 1;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    private int searchUpperBound(int[] nums, int target) {

        int left  = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (mid >= nums.length - 1) {
                    return mid;
                } else {
                    if (nums[mid + 1] != nums[mid]) {
                        return mid;
                    } else {
                        left = mid + 1;
                    }
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1150 solution1150 = new Solution1150();
        boolean      ans          = solution1150.isMajorityElement(new int[]{10,100,101,101}, 2);
        System.out.println(ans);
    }
}
