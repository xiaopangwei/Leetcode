package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 11:16 PM
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {

        int left  = 0;
        int right = 1000000000;

        while (left <= right) {

            int mid   = (left + right) / 2;
            int count = 0;
            for (int item : piles) {
                if (item <= mid) {
                    count += 1;
                } else {
                    count += Math.ceil(item * 1.0 / mid);
                }
            }

            if (count > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution875 solution875 = new Solution875();
        int         ans         = solution875.minEatingSpeed(new int[]{30,11,23,4,20}, 6);
        System.out.println(ans);
    }
}
