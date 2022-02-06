package leetcode.springfestival.pm20220205;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 4:55 PM
 */
public class Solution384 {
    int[] nums;

    public Solution384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {

        return this.nums;
    }

    public int[] shuffle() {
        int[] copy = nums.clone();
        // 0 [0,10)
        // 1 [1,10)=>[0,9)+1
        // 2 [2,10)=>[0,8)+1

        for (int i = 0; i < copy.length; i++) {
//            new Random().
            int index = new Random().nextInt(copy.length - i) + i;
            swap(copy, i, index);
        }
        return copy;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution384 solution384 = new Solution384(new int[]{1, 4, 2, 6, 1, 9, 100, 3});
        int[]       nums        = solution384.shuffle();
        System.out.println(Arrays.toString(nums));

        System.out.println(Arrays.toString(solution384.reset()));
    }
}
