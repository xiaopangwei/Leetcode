package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 9:03 PM
 */
public class Solution264 {
    public int nthUglyNumber(int n) {

        int[] ans = new int[n + 1];
        ans[1] = 1;
        int val1 = 2;
        int val2 = 3;
        int val3 = 5;
        for (int i = 2; i <= n; i++) {
            System.out.println(val1+" "+val2+" "+val3);
            ans[i] = Math.min(val1, Math.min(val2, val3));
            System.out.println(ans[i]);
            if (ans[i] == val1) {
                val1 += 2;
            }
            if (ans[i] == val2) {
                val2 += 3;
            }
            if (ans[i] == val3) {
                val3 += 5;
            }

        }
        return ans[n];
    }

    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        int         n           = solution264.nthUglyNumber(13);
        System.out.println(n);
    }
}
