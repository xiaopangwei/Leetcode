package leetcode.p2022m05.day0521;

import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/21
 * @time 10:22 AM
 */
public class Solution961 {
    public int repeatedNTimes(int[] nums) {
        while (true) {
            int x = new Random().nextInt(nums.length);
            int y = new Random().nextInt(nums.length);

            if (x == y) {
                continue;
            }

            if (nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }

    public static void main(String[] args){
        Solution961 solution961=new Solution961();
        int nums=solution961.repeatedNTimes(new int[]{1,2,3,3});
        System.out.println(nums);
    }
}
