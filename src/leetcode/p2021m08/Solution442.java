package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 4:13 PM
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int           len = nums.length;
        for (int i = 0; i < len; i++) {
            //num[i]==>i-1
            int target = nums[i];
            int idx    = Math.abs(target) - 1;

//            System.out.println("=> "+i+" "+ Arrays.toString(nums));
            if (nums[idx] >= 0) {
                nums[idx] *= -1;
            } else {
                res.add(idx + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution442 solution442 = new Solution442();
        List<Integer> ans=solution442.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(ans);
    }
}
