package leetcode.p2021m08;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/29
 * @time 8:10 PM
 */
public class Solution273 {


    int mod = 1000;

    Map<Integer, String> map = new HashMap<>();

    String[] gewei   = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] shiwei1 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] shiwei2 = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    String[] danwei = {"", "Thousand", "Million", "Billion"};


    public String numberToWords(int num) {
        LinkedList<LinkedList<String>> res = new LinkedList<>();
        if (num == 0) {
            return "Zero";
        }
        int count = 0;
        while (num != 0) {
            int   thiNumber = num % mod;
            int[] digits    = new int[3];
            int   k         = 2;
            while (thiNumber != 0) {
                int temp = thiNumber % 10;
                digits[k--] = temp;
                thiNumber /= 10;
            }
            LinkedList<String> linkedList = new LinkedList<>();
            if (digits[0] != 0) {
                linkedList.addLast(gewei[digits[0]]);
                linkedList.addLast("Hundred");
            }
            if (digits[1] != 0) {
                if (digits[1] == 1) {
                    int index = digits[2];
                    linkedList.addLast(shiwei1[index]);
                } else {

                    linkedList.addLast(shiwei2[digits[1] - 2]);
                    if (digits[2] != 0) {
                        linkedList.addLast(gewei[digits[2]]);
                    }
                }
            } else {

                if (digits[2] != 0) {
                    linkedList.addLast(gewei[digits[2]]);
                }
            }
            if (digits[0] != 0 || digits[1] != 0 || digits[2] != 0) {
                if (danwei[count].length() > 0) {
                    linkedList.addLast(danwei[count]);
                }

            }

            res.addFirst(linkedList);


            count++;
            num = num / mod;
        }


        StringBuilder builder = new StringBuilder();
        for (LinkedList<String> item : res) {
            if (!item.isEmpty()) {
                builder.append(String.join(" ", item));
                builder.append(" ");
            }
        }


        String temp = builder.toString();
        int    idx  = temp.length() - 1;
        while (idx >= 0 && temp.charAt(idx) == ' ') {
            idx--;
        }
        return temp.substring(0, idx + 1);

    }

    public static void main(String[] args) {
        Solution273 solution273 = new Solution273();
        String      ans         = solution273.numberToWords(1000010);
        System.out.println(ans);
    }
}
