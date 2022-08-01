package leetcode.p2022m07;

import leetcode.unknown.ArraysTest;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/20
 * @time 8:50 PM
 */
public class Solution457 {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            if ((nums[i] > 0 && dfs(nums, i, true, visited)) ||
                    (nums[i] < 0 && dfs(nums, i, false, visited))) {
                return true;
            }

            Arrays.fill(visited, false);

        }
        return false;
    }


    private boolean isSame(int[] nums, int index, boolean flag) {
        if (nums[index] == 0) {
            return false;
        }
        if (flag) {
            return nums[index] > 0;
        } else {
            return nums[index] < 0;
        }
    }

    private boolean dfs(final int[] nums, int startIndex, final boolean forwardDirection, final boolean[] visited) {

//        System.out.println(startIndex+" "+forwardDirection);
        int nextIndex = -1;
        int n         = nums.length;
        visited[startIndex] = true;
        if (forwardDirection) {
            nextIndex = (startIndex + nums[startIndex]) % n;
        } else {
            nextIndex = ((startIndex + nums[startIndex]) % n + n) % n;
        }

        if (startIndex==nextIndex){
            return false;
        }
        if (!isSame(nums, startIndex, forwardDirection)) {
            return false;
        }

        if (visited[nextIndex]) {
            System.out.println(Arrays.toString(visited));
            return true;
        }

        visited[nextIndex] = true;
        if (dfs(nums, nextIndex, forwardDirection, visited)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution457 solution457=new Solution457();
        boolean ans=solution457.circularArrayLoop(new int[]{-1,2});
        System.out.println(ans);
    }
}
