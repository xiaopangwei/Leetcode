package leetcode.springfestival.pm20220205;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/1
 * @time 2:57 PM
 */
public class Solution564 {
    public String nearestPalindromic(String n) {

        int len  = n.length();
        int intN = Integer.parseInt(n);
        if (intN <= 10) {
            return String.valueOf(intN - 1);
        }
        if (intN == 11) {
            return "9";
        }
        boolean flag = len % 2 == 0;
        int     left = Integer.parseInt(n.substring(0, (len + 1) / 2));

        if (flag) {

            int smaller  = left - 1;
            int n1       = concat(String.valueOf(smaller), 0);
            int original = left;
            int n2       = concat(String.valueOf(original), 0);
            int bigger   = left + 1;
            int n3       = 0;
            if (String.valueOf(bigger).length() > String.valueOf(left).length()) {
                n3 = concat(String.valueOf(bigger), 1);
            } else {
                n3 = concat(String.valueOf(bigger), 0);
            }


            return getMinGap(intN, n1, n2, n3);
        } else {
            int smaller  = left - 1;
            int n1       = concat(String.valueOf(smaller), 1);
            int original = left;
            int n2       = concat(String.valueOf(original), 1);
            int bigger   = left + 1;
            int n3       = 0;
            if (String.valueOf(bigger).length() > String.valueOf(left).length()) {
                n3 = concat(String.valueOf(bigger), 0);
            } else {
                n3 = concat(String.valueOf(bigger), 1);
            }
            return getMinGap(intN, n1, n2, n3);
        }
    }


    private int concat(String number, int offset) {
        StringBuilder reversed = new StringBuilder(String.valueOf(number)).reverse();
        if (reversed.length() >= 2) {
            return Integer.parseInt(new StringBuilder(number).append(reversed.substring(offset)).toString());
        } else {
            return Integer.parseInt(new StringBuilder(number).append(reversed).toString());
        }
    }

    private String getMinGap(int n, int... array) {
        int gap = Integer.MAX_VALUE;
        int val = -1;
        for (int i = 0; i < array.length; i++) {
            int absVal = Math.abs(array[i] - n);
            if (absVal < gap && absVal != 0) {
                val = array[i];
                gap = absVal;
            }
        }
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        Solution564 solution564 = new Solution564();
        String      ans         = solution564.nearestPalindromic("999");
        System.out.println(ans);
    }
}
