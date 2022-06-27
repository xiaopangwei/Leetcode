package leetcode.p2022m06.p20220625;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/25
 * @time 3:14 PM
 */
public class Solution698 {
    int[]     nums;
    int       k;
    int       target;
    boolean[] visited;

    public boolean canPartitionKSubsets(int[] nums, int k) {

        this.nums = nums;
        Arrays.sort(this.nums);
        this.k = k;
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        visited = new boolean[nums.length];
        if (sum % k != 0) {
            return false;
        }
        return dfs(0, 0, 0, sum / k);
    }

    private boolean dfs(int startIndex, int currentSum, int already, int target) {
        if (already == this.k) {
            return true;
        }

        if (currentSum > target) {
            return false;
        }

        if (currentSum == target) {
            return dfs(0, 0, already + 1, target);
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] + currentSum > target) {
                break;
            }
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            boolean flag = dfs(startIndex + 1, currentSum + nums[i], already, target);
            if (flag) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution698 solution698 = new Solution698();
        //nums = [4, 3, 2, 3, 5, 2, 1], k = 4
        boolean flag = solution698.canPartitionKSubsets(new int[]{1,2,3,4}, 3);
        System.out.println(flag);
    }
}
