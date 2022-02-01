package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 4:08 PM
 */
public class Solution166 {
    public String fractionToDecimal(int x, int y) {


        long    numerator   = (long) x;
        long    denominator = (long) y;
        if (y==1){
            return String.valueOf(x);
        }
        boolean flag        = true;
        if (numerator < 0 && denominator > 0) {
            flag = false;
        }

        if (numerator > 0 && denominator < 0) {
            flag = false;
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        if (numerator == 0 || numerator % denominator == 0) {
            return String.valueOf(numerator / denominator);
        }
        long       remained     = numerator % denominator;
        long       ratio        = numerator / denominator;
        List<Long> remainedList = new ArrayList<>();
        List<Long> ratioList    = new ArrayList<>();
        int        count        = 0;

        long b = denominator;
        remainedList.add(remained);
        ratioList.add(ratio);
        StringBuilder      builder     = new StringBuilder();
        Map<Long, Integer> positionMap = new HashMap<>();
        if (!flag) {
            builder.append("-");
        }
        builder.append(ratio);
        builder.append(".");
//        remained = remained - (remained / denominator) * denominator;
        positionMap.put(remained, count++);
        int  length = 0;
        long a      = remained;
        while (true) {

            long temp = (a * 10) % b;
            long r    = (a * 10) / b;
            remained = temp;
            ratioList.add(r);
            if (positionMap.containsKey(remained)) {

                length = count - positionMap.get(remained);
                int e = positionMap.get(remained);
                for (int i = 1; i <= e; i++) {
                    builder.append(ratioList.get(i));
                }
                builder.append("(");
                for (int i = e + 1; i < e + 1 + length; i++) {
                    builder.append(ratioList.get(i));
                }
                builder.append(")");
                break;
            } else {
                positionMap.put(remained, count++);

            }
            if (remained == 0) {
                for (int i = 1; i < ratioList.size(); i++) {
                    builder.append(ratioList.get(i));
                }
                break;
            }
            remainedList.add(remained);
            a = remained;
        }


        return builder.toString();

    }

    public static void main(String[] args) {
        Solution166 solution166 = new Solution166();
        String      ans         = solution166.fractionToDecimal(-2147483648, 1);
        System.out.println(ans);
    }
}
