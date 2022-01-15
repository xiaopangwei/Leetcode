package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/11
 * @time 9:04 PM
 */
public class Solution1363 {
    public String largestMultipleOfThree(int[] digits) {

        Arrays.sort(digits);
        int           sum     = 0;
        List<Integer> oneList = new ArrayList<>();
        List<Integer> twoList = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            int item = digits[i];
            if (item % 3 == 1) {
                oneList.add(i);
            } else if (item % 3 == 2) {
                twoList.add(i);
            }
        }

        if (sum % 3 == 0) {
            return buildInteger(digits, -1, -1);
        } else if (sum % 3 == 1) {
            if (oneList.isEmpty()) {
                return buildInteger(digits, twoList.get(0), twoList.get(1));
            } else {
                return buildInteger(digits, oneList.get(0), -1);
            }
        } else {
            if (twoList.isEmpty()) {
                return buildInteger(digits, oneList.get(0), oneList.get(1));
            } else {
                return buildInteger(digits, twoList.get(0), -1);
            }
        }
    }

    public String buildInteger(int[] digits, int ignore1Index, int ignore2Index) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != ignore1Index && i != ignore2Index) {
                stringBuilder.append(digits[i]);
            }
        }

        if (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '0') {
            return "0";
        } else {
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Solution1363 solution1363 = new Solution1363();
        //[8,7,0,7,7]
        String ans = solution1363.largestMultipleOfThree(new int[]{8, 7, 0, 7, 7});
        System.out.println(ans);
    }
}
