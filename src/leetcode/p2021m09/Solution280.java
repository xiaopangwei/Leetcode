package leetcode.p2021m09;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/16
 * @time 9:58 PM
 */
public class Solution280 {
    public void wiggleSort(int[] nums) {
        int[] copy = nums.clone();
//        Arrays.fill(nums, 0);
        Arrays.sort(copy);

        if (nums.length%2!=0) {
            int k = 0;
            for (int i = 0; i <= nums.length / 2; i++) {
                nums[k] = copy[i];
                k += 2;
            }
            k = 1;
            for (int i = nums.length / 2 + 1; i < nums.length; i++) {
                nums[k] = copy[i];
                k += 2;
            }
        }else{
            int k = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                nums[k] = copy[i];
                k += 2;
            }
            k = 1;
            for (int i = nums.length / 2 ; i < nums.length; i++) {
                nums[k] = copy[i];
                k += 2;
            }
        }

//        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Solution280 solution280 = new Solution280();
        solution280.wiggleSort(new int[]{3, 5, 2, 1, 6, 4});
    }
}
