package leetcode.p2021m12;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/30
 * @time 9:11 PM
 */
public class Solution372 {
    int mod = 1337;

    public int superPow(int a, int[] b) {

        LinkedList<Integer> list = new LinkedList<>();
        for (int item : b) {
            list.addLast(item);
        }

        return superPow(list, a);
    }

    public int superPow(LinkedList<Integer> list, int x) {
        if (list.isEmpty()) {
            return 1;
        }
        int t = list.removeLast();
        int a = pow(x, t) % mod;
        int b = pow(superPow(list, x), 10) % mod;
        return (a * b) % mod;
    }

    private int pow(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        int t = (x % mod);
        if (n % 2 == 0) {

            return pow((t * t) % mod, n / 2);
        } else {
            return ((pow(x, n - 1) % mod) * t) % mod;
        }
    }

    public static void main(String[] args) {
        Solution372 solution372 = new Solution372();
        int         ans         = solution372.superPow(2, new int[]{1, 0});
        System.out.println(ans);
    }

}
