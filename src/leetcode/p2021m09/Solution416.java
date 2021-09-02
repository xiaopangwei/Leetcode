package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/1
 * @time 9:50 PM
 */
public class Solution416 {

    static class BiKey {
        public int index;
        public int currentSum;

        public BiKey(int index, int currentSum) {
            this.index = index;
            this.currentSum = currentSum;
        }

        @Override
        public boolean equals(Object o) {
            BiKey biKey = (BiKey) o;

            if (index != biKey.index) return false;
            return currentSum == biKey.currentSum;
        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + currentSum;
            return result;
        }
    }

    private Map<String, Boolean> cached = new HashMap<>();

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        return dfs(0, nums, 0, half);


    }


    private boolean dfs(int index, final int[] number, int currentSum, final int target) {
//        System.out.println(index + " " + currentSum);
        String key = index + "#" + currentSum;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }

        if (index >= number.length || currentSum > target) {
            return false;
        }
        if (currentSum == target) {
            return true;
        }

        if (dfs(index + 1, number, number[index] + currentSum, target) ||
            dfs(index + 1, number, currentSum, target)) {


            cached.put(key, true);

            return true;
        } else {

            cached.put(key, false);

            return false;
        }

    }


    public static void main(String[] args) {
//        int[]       arr         = {40, 99, 2, 19, 62, 76, 70, 2, 58, 9, 72, 93, 99, 78, 22, 82, 30, 33, 14, 100, 4, 58, 43, 59, 11, 84, 43, 57, 54, 25, 54, 67, 55, 87, 61, 51, 40, 10, 17, 37, 77, 22, 6, 70, 31, 9, 91, 15, 31, 23, 54, 73, 73, 91, 32, 65, 42, 35, 68, 35, 46, 4, 15, 55, 81, 13, 14, 99, 17, 30, 31, 57, 34, 30, 1, 75, 2, 45, 77, 36, 76, 39, 44, 26, 94, 3, 9, 25, 56, 99, 13, 61, 22, 5, 60, 9, 43, 94, 1, 31};
//        int[]       array       = arr;
        int[]       array       = new int[]{1, 2, 3, 4, 5, 6, 7};
        Solution416 solution416 = new Solution416();
        boolean     res         = solution416.canPartition(array);
        System.out.println(res);
    }
}
