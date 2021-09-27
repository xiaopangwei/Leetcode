package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/24
 * @time 11:54 PM
 */
public class Solution800 {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        for (char ch = '0'; ch <= '9'; ch++) {
            map.put(ch, ch - '0');
        }
        for (char ch = 'a'; ch <= 'f'; ch++) {
            map.put(ch, 10 + ch - 'a');
        }

    }

    public String similarRGB(String color) {


        StringBuilder builder = new StringBuilder("#");
        int           i       = 1;
        while (i < color.length()) {
            if (color.charAt(i) == color.charAt(i + 1)) {
                builder.append(color.charAt(i));
                builder.append(color.charAt(i));
            } else {

                char ch  = color.charAt(i);
                int  sum = getSum(ch, color.charAt(i + 1));

                int sum1 = 0;
                int sum2 = 0;
                int sum3 = 0;


                char prev = getPrev(ch);
                char next = getNext(ch);
                sum1 = getSum(prev, prev);
                sum2 = getSum(next, next);
                sum3 = getSum(ch, ch);


                if (Math.abs(sum - sum1) < Math.abs(sum - sum2) && Math.abs(sum - sum1) < Math.abs(sum - sum3)) {
                    builder.append(String.valueOf(prev));
                    builder.append(String.valueOf(prev));
                } else if (Math.abs(sum - sum2) < Math.abs(sum - sum1) && Math.abs(sum - sum2) < Math.abs(sum - sum3)) {
                    builder.append(String.valueOf(next));
                    builder.append(String.valueOf(next));
                } else {
                    builder.append(String.valueOf(ch));
                    builder.append(String.valueOf(ch));
                }


            }

            i += 2;
        }
        return builder.toString();
    }

    private int getSum(char high, char low) {
        return 16 * map.get(high) + map.get(low);
    }

    private char getNext(char ch) {
        if (ch == 'f') {
            return '0';
        } else if (ch == '9') {
            return 'a';
        }
        return (char) (ch + 1);
    }


    private char getPrev(char ch) {
        if (ch == '0') {
            return 'f';
        } else if (ch == 'a') {
            return '9';
        }
        return (char) (ch - 1);
    }

    public static void main(String[] args) {
        Solution800 solution800 = new Solution800();
        String      ans         = solution800.similarRGB("#29e626");
        System.out.println(ans);
    }
}
