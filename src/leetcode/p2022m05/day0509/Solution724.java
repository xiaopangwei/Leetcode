package leetcode.p2022m05.day0509;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 8:24 PM
 */
public class Solution724 {
    public int pivotIndex(int[] nums) {

        int s = 0;
        for (int item : nums) {
            s += item;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = s - nums[i];
            if (temp % 2 == 0 && temp / 2 == sum) {
                return i;
            } else {
                sum += nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]       array       = new int[]{2, 1, -1};
        Solution724 solution724 = new Solution724();
        int         ans         = solution724.pivotIndex(array);
        System.out.println(ans);
    }
}
