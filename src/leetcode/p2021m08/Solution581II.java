package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/3
 * @time 9:21 AM
 */
public class Solution581II {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int left   = -1;
        int right  = -1;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int i      = len - 1;
        while (i >= 0) {
            if (nums[i] <= minVal) {
                minVal = nums[i];
            } else {
                left = i;
            }
            i--;
        }

        int j = 0;
        while (j <= len - 1) {
            if (nums[j] >= maxVal) {
                maxVal = nums[j];
            } else {
                right = j;
            }
            j++;
        }
        if (left == -1 && right == -1) {
            return 0;
        } else {
            return right - left + 1;
        }

    }

    public static void main(String[] args) {
        Solution581II solution581 = new Solution581II();
        int           ans         = solution581.findUnsortedSubarray(new int[]{1,2,3,3,3});
        System.out.println(ans);
    }
}
