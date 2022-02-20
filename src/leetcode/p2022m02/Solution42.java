package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/18
 * @time 10:50 PM
 */
public class Solution42 {
    public int trap(int[] height) {

        int[] left  = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        right[right.length - 1] = height[right.length - 1];

        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(right[i], left[i]) - height[i];
            ans += temp;
        }
        return ans;
    }
}
