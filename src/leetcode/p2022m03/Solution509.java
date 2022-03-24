package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/15
 * @time 9:18 PM
 */
public class Solution509 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;

        int c = a + b;
        for (int i = 2; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }



    public static void main(String[] args) {
        Solution509 solution509 = new Solution509();
        int         ans         = solution509.fib(5);
        System.out.println(ans);
    }
}
