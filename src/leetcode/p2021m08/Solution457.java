package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/7
 * @time 10:36 AM
 */
public class Solution457 {
    private int[] nums;
    int n;

    public boolean circularArrayLoop(int[] nums) {

        this.nums = nums;
        int length = nums.length;
        this.n = length;


        for (int i = 0; i < nums.length; i++) {
            int     slow = i;
            int     fast = next(i);
            boolean flag = false;
            while (true) {
                if (nums[i] * nums[slow] < 0 || nums[i] * nums[fast] < 0) {
                    break;
                }
                if (slow == fast) {
                    if (slow == next(slow) || fast == next(fast)) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                        break;
                    }
                }
                slow = next(slow);
                fast = next(next(fast));
            }
            if (flag) {
                return true;
            }
        }

        return false;
    }

    private int next(int idx) {
        return (idx + nums[idx] + this.n) % n;
    }

    public static void main(String[] args) {
        Solution457 solution457 = new Solution457();
        int[]       array       = {-1,2};
        boolean     ans         = solution457.circularArrayLoop(array);
        System.out.println(ans);
    }
}
