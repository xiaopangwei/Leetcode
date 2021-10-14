package leetcode.p2021m10;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/12
 * @time 8:53 PM
 */
public class Solution2035 {


    public int minimumDifference(int[] nums) {

        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int   len      = nums.length;
        int[] positive = new int[len];
        int   sum      = 0;
        int   minVal   = Integer.MAX_VALUE;
        for (int val : nums) {
            minVal = Math.min(minVal, val);
            sum += val;
        }

        if (minVal < 0) {
            int gap = -minVal;
            for (int i = 0; i < len; i++) {
                positive[i]=nums[i]+gap;
            }
            sum += gap * nums.length;
        }else{
            for (int i = 0; i < len; i++) {
                positive[i]=nums[i];
            }
        }


        Arrays.sort(positive);


        int currentSum = 0;
        int half       = len / 2;
        for (int i = 0; i < half; i++) {
            currentSum += positive[i];
        }
        System.out.println(currentSum);
        minVal=Integer.MAX_VALUE;
        minVal = Math.min(minVal, Math.abs(currentSum - (sum - currentSum)));
        int i = 0;
        while (i < len) {
            int j = i + half;
            if (j >= len) {
               break;
            }
            currentSum -= positive[i];
            currentSum += positive[j];
            System.out.println(currentSum);
            minVal = Math.min(minVal, Math.abs(currentSum - (sum - currentSum)));
            i++;
        }


        return minVal;

    }


    public static void main(String[] args) {
        Solution2035 solution2035 = new Solution2035();
        int[]        array        = {7772197, 4460211, -7641449, -8856364, 546755, -3673029, 527497, -9392076, 3130315, -5309187, -4781283, 5919119, 3093450, 1132720, 6380128, -3954678, -1651499, -7944388, -3056827, 1610628, 7711173, 6595873, 302974, 7656726, -2572679, 0, 2121026, -5743797, -8897395, -9699694};
        int          ans          = solution2035.minimumDifference(array);

//        int ans = solution2035.minimumDifference(new int[]{3,9,7,3});
        System.out.println(ans);
    }
}
