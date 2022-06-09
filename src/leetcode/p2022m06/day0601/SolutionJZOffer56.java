package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 10:42 PM
 */
public class SolutionJZOffer56 {
    public int singleNumber(int[] nums) {
        long base = 1;
        long ans  = 0;
        for (int i = 0; i < 32; i++) {

            int s = 0;
            for (int k = 0; k < nums.length; k++) {
                s += (nums[k] & base);
            }

            if (s % 3 != 0) {
                ans += base;
            }

            base <<= 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        SolutionJZOffer56 solutionJZOffer56 = new SolutionJZOffer56();
        int               ans               = solutionJZOffer56.singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7});
        System.out.println(ans);
    }
}
