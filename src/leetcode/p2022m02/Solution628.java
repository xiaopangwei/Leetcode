package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 4:17 PM
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MAX_VALUE;

        for (int item : nums) {
            if (item < min1) {
                min2 = min1;
                min1 = item;
            } else if (item < min2) {
                min2 = item;
            }


            if (item > max1) {
                max3 = max2;
                max2 = max1;
                max1 = item;
            } else if (item > max2) {
                max3 = max2;
                max2 = item;
            } else if (item > max3) {
                max3 = item;
            }
        }

        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
}
