package leetcode.springfestival.sf20220130;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 10:07 AM
 */
public class SolutionJZOffer21 {
    public int[] exchange(int[] nums) {

        //奇数前偶数后
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }
            while (i < j && nums[j] % 2 == 0) {
                j--;
            }
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SolutionJZOffer21 solutionJZOffer21 = new SolutionJZOffer21();
        int[]             ans               = solutionJZOffer21.exchange(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ans));

    }
}
