package leetcode.springfestival.pm20220205;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/5
 * @time 11:18 AM
 */
public class SolutionJZOffer03 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {

            if (nums[i] == i) {
                i++;
                continue;
            } else {
                System.out.println(Arrays.toString(nums));
                int newIndex = nums[i];
                if (nums[newIndex] == nums[i]) {
                    return nums[i];
                } else {
                    swap(nums, i, newIndex);
                }
            }
        }
        return -1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args){
        SolutionJZOffer03 solutionJZOffer03=new SolutionJZOffer03();
        solutionJZOffer03.findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3});
    }
}
