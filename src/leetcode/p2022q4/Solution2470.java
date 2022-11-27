package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/20
 * @time 10:35 PM
 */
public class Solution2470 {
    public int subarrayLCM(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (t == k) {
                res++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int temp = t * nums[j] / gcd(t, nums[j]);
                if (temp == k) {
                    res++;
                }
                if (temp > k) {
                    break;
                }
            }
        }
        return res;
    }


    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution2470 solution2470 = new Solution2470();
        System.out.println(solution2470.subarrayLCM(new int[]{3}, 2));
    }
}
