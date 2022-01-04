package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 4:54 PM
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;

        int idx2 = 1;
        int idx3 = 1;
        int idx5 = 1;


        for (int i = 2; i <= n; i++) {
            int a = ans[idx2] * 2;
            int b = ans[idx3] * 3;
            int c = ans[idx5] * 5;

            int min = Math.min(a, Math.min(b, c));
            if (min == a) {
                idx2++;
            }
            if (min == b) {
                idx3++;
            }
            if (min == c) {
                idx5++;
            }
            ans[i] = min;
        }

        return ans[n];
    }

    public static void main(String[] args) {
        Solution264 solution264 = new Solution264();
        int         ans         = solution264.nthUglyNumber(10);
        System.out.println(ans);
    }
}
