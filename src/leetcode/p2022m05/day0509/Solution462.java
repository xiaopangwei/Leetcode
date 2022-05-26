package leetcode.p2022m05.day0509;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 8:02 PM
 */
public class Solution462 {
    public int minMoves2(int[] nums) {
        int i   = 0;
        int j   = nums.length - 1;
        int ans = 0;
        while (i < j) {
            ans += nums[j] - nums[i];
            j--;
            i++;
        }
        return ans;
    }
}
