package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 10:20 PM
 */
public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {

        int lenOfS = s.length();
        int lenOfT = t.length();

        int minLen = Math.min(lenOfS, lenOfT);

        if (Math.abs(lenOfS - lenOfT) > 1) {
            return false;
        }

        if (s.equals(t)) {
            return false;
        }

        if (lenOfS > lenOfT) {
            String temp = s;
            s = t;
            t = temp;
        }

        for (int i = 0; i < minLen; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (!s.substring(i + 1).equals(t.substring(i + 1)) &&
                        !s.substring(i).equals(t.substring(i + 1))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution161 solution161 = new Solution161();
        boolean     ans         = solution161.isOneEditDistance("ba", "a");
        System.out.println(ans);
    }


}
