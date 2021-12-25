package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 2:35 PM
 */
public class Solution665 {
    public boolean checkPossibility(int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int cnt = 0;
        if (nums[0] > nums[1]) {
            cnt++;
            nums[0] = nums[1];
        }

        for (int i = 1; i < nums.length - 1; i++) {
            int left  = nums[i - 1];
            int mid   = nums[i];
            int right = nums[i + 1];
            if (left <= mid && mid <= right) {
                continue;
            }
            cnt++;
            if (cnt > 1) {
                return false;
            }
            if (left > right) {
                nums[i + 1] = mid;
            } else {
                nums[i] = left;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution665 solution665=new Solution665();
        boolean ans=solution665.checkPossibility(new int[]{4,2,1});
        System.out.println(ans);
    }
}
