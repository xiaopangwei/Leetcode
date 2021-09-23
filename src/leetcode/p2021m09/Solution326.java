package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 10:04 AM
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {

        if (n < 3) {
            return false;
        }

        return dfs(n);

    }


    private boolean dfs(int n) {

        if (n == 1) {
            return true;
        }
        int a = n / 3;
        int b = n % 3;
        if (b != 0) {
            return false;
        }
        return dfs(a);
    }

    public static void main(String[] args) {
        Solution326 solution326 = new Solution326();
        boolean     ans         = solution326.isPowerOfThree(45);
        System.out.println(ans);
    }

}
