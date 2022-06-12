package leetcode.p2022m03;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 8:31 PM
 */
public class Solution135 {
    public int candy(int[] ratings) {
        int[] ans = new int[ratings.length];
        Arrays.fill(ans, 1);
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                ans[i + 1] = ans[i] + 1;
            }
        }
        System.out.println(Arrays.toString(ans));

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i + 1] + 1, ans[i]);
            }
        }


        System.out.println(Arrays.toString(ans));
        int s = 0;
        for (int item : ans) {
            s += item;
        }
        return s;
    }

    public static void main(String[] args) {
        int[]       array       = new int[]{1, 2, 87, 87, 87, 2, 1};
        Solution135 solution135 = new Solution135();
        int         ans         = solution135.candy(array);
        System.out.println(ans);

    }
}
