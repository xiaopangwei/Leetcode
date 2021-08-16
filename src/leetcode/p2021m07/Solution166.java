package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 2:10 PM
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }
        boolean flag = true;
        if (numerator < 0 && denominator > 0) {
            flag = false;
        } else if (numerator > 0 && denominator < 0) {
            flag = false;
        }

        long    a    = Math.abs((long) numerator);
        long    b    = Math.abs((long)denominator);


        long         integerPart = 0;
        List<String> decimalPart = new ArrayList<>();
        List<String> leftPart    = new ArrayList<>();

        int loopStartIndex = 0;
        int loopEndIndex   = 0;
        integerPart = a / b;
        long e = a % b;
        leftPart.add(String.valueOf(e));
        a=e*10;
        boolean modComplete=false;
        while (true) {
            long c = a / b;
            decimalPart.add(String.valueOf(c));
//            System.out.println("Decimal "+decimalPart);
            long d = a % b;
            if (d == 0) {
                modComplete=true;
                break;
            } else {
                String temp = String.valueOf(d);

                if (leftPart.contains(temp)) {
                    leftPart.add(temp);
                    loopEndIndex = leftPart.lastIndexOf(temp)-1;
                    loopStartIndex = leftPart.indexOf(temp);
                    break;
                } else {
                    leftPart.add(temp);
//                    System.out.println("Left "+leftPart);
                }
            }
            a = d * 10;
        }


        StringBuilder builder = new StringBuilder();
        if (!flag){
            builder.append("-");
        }
        builder.append(String.valueOf(integerPart));
        builder.append(".");
        if (modComplete){
            for (String item:decimalPart){
                builder.append(item);
            }
        }else {
            int length       = loopEndIndex - loopStartIndex + 1;
            int prefixLength = decimalPart.size() - length;
            for (int i = 0; i < prefixLength; i++) {
                builder.append(String.valueOf(decimalPart.get(i)));
            }

            builder.append("(");

            for (int i = prefixLength; i < prefixLength + length; i++) {
                builder.append(String.valueOf(decimalPart.get(i)));
            }
            builder.append(")");
        }

        String ans=builder.toString();

        int pointIndex=ans.indexOf(".");

        boolean nonZeroFlag=false;
        for (int i=pointIndex+1;i<ans.length();i++){
            if (ans.charAt(i)!='0'){
                nonZeroFlag=true;
                break;
            }
        }
        if (!nonZeroFlag){
            return ans.substring(0,pointIndex);
        }else{
            return ans;
        }

    }



    public static void main(String[] args) {
        Solution166 solution166 = new Solution166();
        String      ans         = solution166.fractionToDecimal(-1, -2147483648);
        System.out.println(ans);
    }
}
