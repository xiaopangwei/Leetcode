package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 11:02 PM
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[i] && nums[mid] == nums[j]) {
                i++;
                j--;
            } else if (nums[mid] >= nums[i]) {
                if (nums[i] <= target && target < nums[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution81 solution33 = new Solution81();
        boolean    ans        = solution33.search(new int[]{5,1,3}, 3);
        System.out.println(ans);
    }
}
