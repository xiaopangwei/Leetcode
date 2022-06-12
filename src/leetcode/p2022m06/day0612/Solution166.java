package leetcode.p2022m06.day0612;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/12
 * @time 7:38 PM
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long    a    = (long) numerator;
        long    b    = (long) denominator;
        boolean flag = false;
        if (a > 0 && b > 0) {
            flag = true;
        }
        if (a < 0 && b < 0) {
            flag = true;
        }

        a = Math.abs(a);
        b = Math.abs(b);
        StringBuilder sb = new StringBuilder();
        if (!flag) {
            sb.append("-");
        }
        if (a % b == 0) {
            sb.append(a / b);
            return sb.toString();
        } else {
            sb.append(a / b);
            sb.append(".");
        }

        Map<Long, Integer> pos = new HashMap<>();
        a = (a % b) * 10;
        while (a != 0 && !pos.containsKey(a)) {
//            System.out.println(a+" "+pos);
            pos.put(a, sb.length());
            sb.append(a / b);
            a = (a % b) * 10;
        }

        if (a == 0) {
            return sb.toString();
        }

        int prevPos = pos.get(a);

        sb.insert(prevPos, "(");
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution166 solution166 = new Solution166();
        String      ans         = solution166.fractionToDecimal(4, 333);
        System.out.println(ans);
    }
}
