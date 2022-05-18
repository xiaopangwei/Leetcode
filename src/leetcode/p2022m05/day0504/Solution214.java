package leetcode.p2022m05.day0504;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 7:54 PM
 */
public class Solution214 {
    public String shortestPalindrome(String s) {
        String r      = new StringBuilder(s).reverse().toString();
        int    length = s.length();
        int idx1 = length;
        int idx2 = 0;
        while (true) {

            String s1 = s.substring(0, idx1);
            String s2 = r.substring(idx2);
            System.out.println(s1 + " " + s2);
            if (s1.equals(s2)) {
                break;
            }
            idx1--;
            idx2++;
        }

        String right = r.substring(0,idx2);
        return right + s;
    }

    public static void main(String[] args) {
        Solution214 solution214 = new Solution214();
        String      ans         = solution214.shortestPalindrome("abcd");
        System.out.println(ans);
    }
}
