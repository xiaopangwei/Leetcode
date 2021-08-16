package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 3:49 PM
 */
public class Solution1822 {
    public int arraySign(int[] nums) {
        int len   = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                count++;
            }
        }
        if (count % 2 == 0) {
            return 1;
        }
        return -1;
    }
}
