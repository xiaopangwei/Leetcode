package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 2:51 PM
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (true) {
                if (nums[i] <= 0 || nums[i] >= nums.length + 1) {
                    break;
                }
                if (nums[i] == i + 1) {
                    break;
                }
                int index = nums[i] - 1;
                if (nums[i] == nums[index]) {
                    break;
                }
                int temp = nums[index];
                //i<->index
                nums[index] = nums[i];
                nums[i] = temp;

            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        int        ans        = solution41.firstMissingPositive(new int[]{1, 1});
        System.out.println(ans);
    }
}
