package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/24
 * @time 8:45 PM
 */
public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return getCount(nums, right) - getCount(nums, left - 1);
    }

    private int getCount(int[] nums, int max) {
        int ans   = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                count++;
                ans += count;
            } else {
                count = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Solution795 solution795=new Solution795();
        System.out.println(solution795.numSubarrayBoundedMax(new int[]{2,1,4,3},2,3));
    }
}
