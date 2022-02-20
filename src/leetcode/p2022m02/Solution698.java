package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/17
 * @time 7:38 PM
 */
public class Solution698 {

    int k        = 0;
    int sliceSum = 0;
    int[]     nums;
    boolean[] visited;
//    List<List<Integer>> nestedList = new ArrayList<>();

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % k != 0) {
            return false;
        }

        this.visited = new boolean[nums.length];
        this.k = k;
        this.sliceSum = sum / k;
        this.nums = nums;
        Arrays.sort(nums);

        if (nums[nums.length - 1] > sliceSum) {
            return false;
        }
        //startIndex
        return dfs(nums, 0, 0, 0);

    }

    private boolean dfs(int[] nums, int count, int currentSum, int startIndex) {
        if (count == this.k) {
            return true;
        }

        if (currentSum == sliceSum) {
            //注意
            return dfs(nums, count + 1, 0, 0);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            int temp = currentSum + nums[i];
            if (temp > sliceSum) {
                //注意是break不是continue 可以和上面的对比
                break;
            }
            visited[i] = true;
            if (dfs(nums, count, temp, i + 1)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution698 solution698 = new Solution698();
        //[2957,4566,1740,1691,594,804,970,327,1473,4163,1097,8564,1633,1577,1944,1464]
        //553,450,2412,1735,521,170,943,87,3200,473,75,3819,492,324,689,629
        //5356,5074,1309,1493,5487,2022,4439,4852,843,798,818,7106,1487,107,8439
        //[1,1,1,1,2,2,2,2]
        //18,20,39,73,96,99,101,111,114,190,207,295,471,649,700,1037
        //129,17,74,57,1421,99,92,285,1276,218,1588,215,369,117,153,22

        boolean ans = solution698.canPartitionKSubsets(new int[]{129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22}, 3);
        System.out.println(ans);
    }
}
