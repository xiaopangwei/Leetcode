package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 11:04 PM
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        slow=nums[slow];
        fast=nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int idx1 = 0;
        int idx2 = slow;
        while (idx1 != idx2) {
            idx1 = nums[idx1];
            idx2 = nums[idx2];
        }
        return idx1;
    }

    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        int         ans         = solution287.findDuplicate(new int[]{3, 3, 3, 1, 2, 3, 4});
        System.out.println(ans);
    }

}
