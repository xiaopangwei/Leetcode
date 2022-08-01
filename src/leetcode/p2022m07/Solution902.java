package leetcode.p2022m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/27
 * @time 8:45 PM
 */
public class Solution902 {
    int[] digit;
    int   n;
    int ans = 0;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        digit = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            digit[i] = Integer.parseInt(digits[i]);
        }
        this.n = n;

        dfs(0);

        return ans;
    }


    private void dfs(int sum) {
        if (sum > n) {
            return;
        }

        for (int i = 0; i < digit.length; i++) {
            int t = sum * 10 + digit[i];
            if (t <= n) {
                System.out.println(t);
                ans++;
                dfs(t);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution902 solution902 = new Solution902();
        solution902.atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100);
    }
}
