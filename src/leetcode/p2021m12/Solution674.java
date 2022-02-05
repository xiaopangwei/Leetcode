package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 10:36 PM
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int max   = 1;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                index = i;
            } else {
                max = Math.max(max, i - index + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution674 solution674 = new Solution674();
        int         len         = solution674.findLengthOfLCIS(new int[]{1,3,5,4,7});
        System.out.println(len);
    }
}
