package leetcode.p2022m05.day0502;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 1:59 PM
 */
public class Solution55 {


    public boolean canJump(int[] nums) {
        int maxCurr = nums[0];
        if (maxCurr >= nums.length - 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            if (i <= maxCurr) {
                maxCurr = Math.max(maxCurr, i + nums[i]);
                if (maxCurr >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        //[5,9,3,2,1,0,2,3,3,1,0,0]
        int[] array = new int[]{2, 0};
        System.out.println(array.length);
        boolean flag = solution55.canJump(array);
        System.out.println(flag);
    }
}
