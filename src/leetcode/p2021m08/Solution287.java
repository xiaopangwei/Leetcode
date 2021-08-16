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

        int slow = nums[0];
        int fast = nums[slow];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int p1 = 0;
        int p2 = slow;

        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

    public static void main(String[] args) {
        Solution287 solution287 = new Solution287();
        int         ans         = solution287.findDuplicate(new int[]{3, 3, 3, 1, 2, 3, 4});
        System.out.println(ans);
    }

}
