package leetcode.p2021m08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 5:17 PM
 */
public class Solution168 {
    public String convertToTitle(int columnNumber) {


        LinkedList<Character> ans = new LinkedList<>();

        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
            map.put(i, (char) ('A' + i));
        }

        int temp = columnNumber;
        while (true) {
            int x = (temp - 1) / 26;
            int y = (temp - 1) % 26;
            ans.addFirst(map.get(y));
            if (x == 0) {
                break;
            } else {
                temp = x;
            }
        }

        char[] res = new char[ans.size()];
        for (int i = 0, k = 0; i < ans.size(); i++) {
            res[k++] = ans.get(i);
        }

        return new String(res);
    }

    public static void main(String[] args) {
        Solution168 solution168 = new Solution168();
        System.out.println(solution168.convertToTitle(2147483647));
    }

}
