package leetcode.p2021m12;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/19
 * @time 8:27 PM
 */
public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int[] leftMax  = new int[nums.length];
        int[] rightMin = new int[nums.length];

        leftMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
        }

        rightMin[rightMin.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], nums[i]);
        }

//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMin));

        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                len = i + 1;
                break;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        Solution915 solution915 = new Solution915();
        //1,1,1,0,6,12
        //5,0,3,8,6
        int ans = solution915.partitionDisjoint(new int[]{1,1,1,0,6,12});


        System.out.println(ans);
    }
}
