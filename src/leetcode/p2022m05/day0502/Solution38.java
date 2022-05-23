package leetcode.p2022m05.day0502;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 10:38 AM
 */
public class Solution38 {

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String        last  = countAndSay(n - 1);
        StringBuilder sb    = new StringBuilder();
        char[]        array = last.toCharArray();
        int           i     = 0;
        while (i < array.length) {
            int j = i + 1;
            while (j < array.length && array[j] == array[i]) {
                j++;
            }

            int len = j - i;
            sb.append(len);
            sb.append(array[i]);
            i = j;
        }
        String ans = sb.toString();
        return ans;
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();
        System.out.println(solution38.countAndSay(5));
    }
}
