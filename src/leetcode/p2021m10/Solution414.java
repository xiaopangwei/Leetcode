package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/6
 * @time 10:07 AM
 */
public class Solution414 {
    public int thirdMax(int[] nums) {


        long firstMax  = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax  = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }

        if (thirdMax == Long.MIN_VALUE) {
            if (firstMax != Long.MIN_VALUE) {
                return (int) firstMax;
            } else {
                return (int) secondMax;
            }
        }
        return (int)thirdMax;
    }

    public static void main(String[] args) {
        Solution414 solution414 = new Solution414();
        int         ans         = solution414.thirdMax(new int[]{1,2});
        System.out.println(ans);
    }
}
