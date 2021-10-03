package leetcode.p2021m10;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 1:10 PM
 */
public class Solution660 {
    public int newInteger(int n) {

        LinkedList<Integer> list = new LinkedList<>();
        if (n == 0) {
            return 0;
        }
        while (n != 0) {
            list.addFirst(n % 9);
            n /= 9;
        }

        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp = temp * 10 + list.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        Solution660 solution660 = new Solution660();
        int         n           = solution660.newInteger(9);
        System.out.println(n);
    }
}
