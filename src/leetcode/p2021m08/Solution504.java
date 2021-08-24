package leetcode.p2021m08;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 10:37 PM
 */
public class Solution504 {
    public String convertToBase7(int num) {

        boolean flag = num >= 0 ? true : false;
        num = Math.abs(num);
        if (num==0){
            return "0";
        }
        LinkedList<Character> list = new LinkedList<>();
        while (num != 0) {
            list.addFirst((char) (num % 7 + '0'));
            num = num / 7;
        }

        char[] res = null;
        int    k   = 0;
        if (!flag) {
            res = new char[list.size() + 1];
            res[k++] = '-';
        } else {
            res = new char[list.size()];
        }
        for (char ch : list) {
            res[k++] = ch;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Solution504 solution504 = new Solution504();
        String      ans         = solution504.convertToBase7(100);
        System.out.println(ans);
    }
}
