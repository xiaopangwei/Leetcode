package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 11:50 PM
 */
public class Solution977 {
    public int[] sortedSquares(int[] nums) {

        int i      = 0;
        int length = nums.length;
        int j      = length - 1;

        int[] squaredArray = new int[length];

        int k = 0;
        while (i <= j) {
            int left  = Math.abs(nums[i]);
            int right = Math.abs(nums[j]);
            if (left > right) {
                squaredArray[length - 1 - k] = left * left;
                k++;
                i++;
            } else if (left < right) {
                squaredArray[length - 1 - k] = right * right;
                k++;
                j--;
            } else {
                if (i != j) {
                    squaredArray[length - 1 - k] = left * left;
                    k++;
                    i++;
                    squaredArray[length - 1 - k] = right * right;
                    k++;
                    j--;
                } else {
                    squaredArray[length - 1 - k] = left * left;
                    k++;
                    i++;
                }
            }
        }

        return squaredArray;
    }

    public static void main(String[] args) {
        Solution977 solution977 = new Solution977();
        int[]       ans         = solution977.sortedSquares(new int[]{-1, 3});
        System.out.println(Arrays.toString(ans));
    }
}
