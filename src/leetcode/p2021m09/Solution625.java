package leetcode.p2021m09;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/23
 * @time 10:10 PM
 */
public class Solution625 {
    public int smallestFactorization(int num) {
        if (num < 10) {
            return num;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        boolean             flag       = dfs(num, linkedList);
        if (flag) {
            long temp = 0;
            for (int i = 0; i < linkedList.size(); i++) {
                temp = temp * 10 + linkedList.get(i);
            }
            if (temp > Integer.MAX_VALUE) {
                return 0;
            } else {
                return (int) temp;
            }
        }
        return 0;
    }

    private boolean dfs(int n, LinkedList<Integer> list) {
        if (n < 10) {
            if (n != 1) {
                list.addFirst(n);
            }
            return true;
        }

        for (int i = 9; i >= 2; i--) {
            if (n % i == 0) {
                list.addFirst(i);
                return dfs(n / i, list);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution625 solution625 = new Solution625();
        int         ans         = solution625.smallestFactorization(18000000);
        System.out.println(ans);
    }
}
