package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/23
 * @time 10:21 PM
 */
public class Solution135 {
    public int candy(int[] ratings) {

        int[] ans = new int[ratings.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = 1;
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                ans[i] = ans[i - 1] + 1;
            }
        }

        //a[i]>a[i+1]

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                ans[i] = Math.max(ans[i], ans[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int i = 0; i < ans.length; i++) {
            sum += ans[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        int         ans         = solution135.candy(new int[]{1, 2, 2});
        System.out.println(ans);
    }
}
