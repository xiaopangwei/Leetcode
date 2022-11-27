package leetcode.p2022q4;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/26
 * @time 4:02 PM
 */
public class Solution805 {

    int total;
    Map<Integer, Boolean> cached = new HashMap<>();

    public boolean splitArraySameAverage(int[] nums) {

        for (int num : nums) {
            total += num;
        }


        return dfs(nums, 0, 0, 0);
    }


    boolean isEquals(int sum, int sizeOfSelected, int[] nums) {
        return Math.abs(sum * 1.0 / sizeOfSelected - (total - sum) * 1.0 / (nums.length - sizeOfSelected)) < 1e-6;
    }

    private boolean dfs(int[] nums, int index, int sum, int sizeOfSelected) {
        Integer key = index * 13 + sum * 7 + sizeOfSelected;
        if (index == nums.length) {
            if (sizeOfSelected < nums.length && isEquals(sum, sizeOfSelected, nums)) {
                cached.put(key, true);
                return true;
            }
            return false;
        }
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        boolean flag = dfs(nums, index + 1, sum + nums[index], sizeOfSelected + 1);
        if (flag) {
            cached.put(key, true);
            return true;
        }
        if (dfs(nums, index + 1, sum, sizeOfSelected)) {
            cached.put(key, true);
            return true;
        }
        cached.put(key, false);
        return false;
    }

    public static void main(String[] args) {
        Solution805 solution805 = new Solution805();
//        19 2 3 24/3=8 11+5/2=8

        System.out.println(solution805.splitArraySameAverage(new int[]{3863, 703, 1799, 327, 3682, 4330, 3388, 6187, 5330, 6572, 938, 6842, 678, 9837, 8256, 6886, 2204, 5262, 6643, 829, 745, 8755, 3549, 6627, 1633, 4290, 7}));
    }
}
