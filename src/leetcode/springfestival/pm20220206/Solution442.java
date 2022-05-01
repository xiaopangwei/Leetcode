package leetcode.springfestival.pm20220206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/6
 * @time 9:57 PM
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        int length=nums.length;
        List<Integer> data = new ArrayList<>();
        //1-n
        for (int item : nums) {
            int index=(item - 1)%length;
            nums[index] += length;
            System.out.println(Arrays.toString(nums));
        }

        System.out.println(Arrays.toString(nums));

        for (int i = 0; i < length; i++) {
            if (nums[i] > 2 * length) {
                data.add(i + 1);
            }
        }
        return data;
    }

    public static void main(String[] args) {
        Solution442   solution442 = new Solution442();
        List<Integer> ans         = solution442.findDuplicates(new int[]{4, 3, 2, 1,3});
        System.out.println(ans);
    }
}
