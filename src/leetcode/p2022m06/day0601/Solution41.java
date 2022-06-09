package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/4
 * @time 2:19 PM
 */
public class Solution41 {
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        boolean flag = false;
        int     i    = 0;
        for (; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            return i + 1;
        } else {
            return nums.length + 1;
        }
    }


    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args){
        Solution41 solution41=new Solution41();
        int ans=solution41.firstMissingPositive(new int[]{7,8,9,11,12});
        System.out.println(ans);
    }
}
