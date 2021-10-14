package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/13
 * @time 10:13 PM
 */
public class Solution214 {


    public String shortestPalindrome(String s) {


        if (s.isEmpty()) {
            return s;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        int    len      = s.length();


        int end1 = len;

        int start2 = 0;


        while (true) {
            if (end1 <= 0 || start2 >= len) {
                break;
            }
            if (s.substring(0, end1).equals(reversed.substring(start2))) {
                break;
            }

            end1--;
            start2++;
        }


        return new StringBuilder(s.substring(end1)).reverse().toString() + s;

    }


    public static void main(String[] args) {
        Solution214 solution214 = new Solution214();
        String      ans         = solution214.shortestPalindrome("aaacecaaa");
        System.out.println(ans);
    }
}
