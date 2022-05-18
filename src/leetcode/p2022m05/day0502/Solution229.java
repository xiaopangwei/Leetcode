package leetcode.p2022m05.day0502;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 11:16 PM
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        int candVal1 = nums[0];
        int candVal2 = nums[0];
        int cnt1     = 0;
        int cnt2     = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candVal1) {
                cnt1++;
            } else if (nums[i] == candVal2) {
                cnt2++;
            } else if (cnt1 == 0) {
                candVal1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                candVal2 = nums[i];
                cnt2 = 1;
            }else {cnt1--;cnt2--;}
        }


        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candVal1) {
                cnt1++;
            }
            if (nums[i] == candVal2) {
                cnt2++;
            }
        }

        Set<Integer> set = new HashSet<>();
        if (cnt1 > nums.length / 3) {
            set.add(candVal1);
        }
        if (cnt2 > nums.length / 3) {
            set.add(candVal2);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Solution229 solution229 = new Solution229();
        solution229.majorityElement(new int[]{1, 1});
    }

}
