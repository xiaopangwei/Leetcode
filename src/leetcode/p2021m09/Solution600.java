package leetcode.p2021m09;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 2:36 PM
 */
public class Solution600 {
    int count = 1;

    public int findIntegers(int n) {

        dfs(1, n);
        return count;

    }
    //0
    //|_01
    //  |_010
    //|_00
    //1
    private void dfs(int val, int n) {
        if (val > n) {
            return;
        }
        count++;
        if (val % 2 == 1) {
            dfs(val << 1, n);
        } else {
            dfs(val << 1, n);
            dfs((val << 1) + 1, n);
        }

    }

    public static void main(String[] args) {
        Solution600 solution600 = new Solution600();
        int         ans         = solution600.findIntegers(5);
        System.out.println(ans);
    }

    private String toBin(int n) {
        LinkedList<Character> list = new LinkedList<>();

        while (n != 0) {
            if (n % 2 != 0) {
                list.addFirst('1');
            } else {
                list.addFirst('0');
            }

            n /= 2;
        }

        char[] array = new char[list.size()];

        int k = 0;


        for (int j = 0; j < list.size(); j++) {
            array[k++] = list.get(j);
        }

        return new String(array);
    }
}
