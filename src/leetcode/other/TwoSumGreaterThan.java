package leetcode.other;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/29
 * @time 9:43 PM
 */
public class TwoSumGreaterThan {
    public int getCount(int[] nums, int target) {
        int i = 0;
        //[1,2,3,4] target=3
        int j   = nums.length - 1;
        int ans = 0;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                System.out.println(i+" "+j);
                ans += (j - i);
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }

}
